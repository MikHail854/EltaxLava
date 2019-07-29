package ru.eltex.app.lab4;

import ru.eltex.app.lab2.Orders;

public class CheckDone extends ACheck {

    CheckDone(Orders orders){
        super(orders);
    }

    public CheckDone(Orders orders, long pause){
        super(orders);
        this.pause = pause;
    }

    public void run(){
        while (fRun){
            getOrders().checkDone();
            try{
                Thread.sleep(pause);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
