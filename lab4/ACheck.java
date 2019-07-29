package ru.eltex.app.lab4;

import ru.eltex.app.lab2.Orders;

abstract public class ACheck implements Runnable {

    public boolean fRun = true;
    public long pause = 3000;
    private Orders orders;


    ACheck(Orders orders){
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

}
