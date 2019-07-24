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
        this.orders = new ArrayList<>();
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
    }

    public void checkTime(){
        for (T order: orders){
            if (order.getStatus() == OrderStatus.WAITING &&
                    order.cheakInterval(System.currentTimeMillis())){
                order.setStatus(OrderStatus.DONE);
            }
        }
    }

    public void checkDone(){
        for (T order: orders){
            if (order.getStatus() == OrderStatus.DONE){
                order.setStatus(OrderStatus.DONE);
                orders.remove((T) order);
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
