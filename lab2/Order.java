package ru.eltex.app.lab2;
import java.sql.Date;

public class Order {

    private ShoppingCart cart;
    private Credentails user;

    private Date dateCreate;
    private long timeWaiting;
    private OrderStatus status;


    public Order(ShoppingCart Cart, Credentails User) {
        this.cart = Cart;
        this.user = User;
        this.status = OrderStatus.WAITING;

        this.dateCreate = new Date(System.currentTimeMillis());
        this.timeWaiting = 1;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean cheakInterval(long time){
        if ((dateCreate.getTime() + timeWaiting) < time){
            return true;
        } else {
            return false;
        }
    }

    public void show(){
        System.out.println("Ваш заказ");
        cart.show();
        user.show();
        System.out.println("Status = " + status);
        System.out.println("Date Create = " + dateCreate);
        System.out.println("Time Waiting = " + timeWaiting);
    }
}
