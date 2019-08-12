package ru.eltex.app.lab2;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

public class Orders <T extends Order> implements Serializable {

    private ArrayList<T> orders;
    private TreeMap<Date, T> dateOrder;

    public Orders(){
        //this.orders = Collections.synchronizedList(new ArrayList<>());
        this.orders = new ArrayList<T>();
        this.dateOrder = new TreeMap<>();
    }

    public Orders(ArrayList<T> list,TreeMap<Date, T> createTime){
        this.orders = list;
        this.dateOrder = createTime;
    }

    void add (T obj){
        this.orders.add(obj);
    }

    void detete(T obj){
        this.orders.remove(obj);
    }

    public void offer(ShoppingCart cart, Credentails user){
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
       // cart.show_short();
    }

    public void checkTime(){
        synchronized (orders){
            Iterator it = orders.iterator();
            while (it.hasNext()){
                Order order = (Order) it.next();
                if(order.getStatus() == OrderStatus.WAITING &&
                        order.checkInterval(System.currentTimeMillis())){
                    order.setStatus(OrderStatus.DONE);
                    System.out.println("Проверка заказа...");
                }

            }
        }
    }

    public void checkDone(){
        synchronized (orders){
            Iterator it = orders.iterator();
            while (it.hasNext()){
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.DONE){
                    it.remove();
                    System.out.println("Удаление заказа");
                }
            }
        }
    }

    public void show(){
        for (T order: orders){
            System.out.println("----------------------------");
            order.show();
        }
    }
}