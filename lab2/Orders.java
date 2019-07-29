package ru.eltex.app.lab2;

import java.sql.Date;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Orders <T extends Order> {

    private List<T> orders;
    private Map<Date, T> dateOrder;

    public Orders(){
        this.orders = Collections.synchronizedList(new ArrayList<>());
        this.dateOrder = new TreeMap<>();
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
        cart.show_short();
    }

    public void checkTime(){
        synchronized (orders){
            Iterator it = orders.iterator();
            while (it.hasNext()){
                Order order = (Order) it.next();
                if(order.getStatus() == OrderStatus.WAITING &&
                        order.cheakInterval(System.currentTimeMillis())){
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
