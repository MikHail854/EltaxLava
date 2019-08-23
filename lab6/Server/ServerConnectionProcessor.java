package ru.eltex.app.lab6.Server;

import ru.eltex.app.lab2.Orders;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Класс для работы в потоке для принятия заказов по TCP
 */

//public class ServerConnectionProcessor implements Runnable{
public class ServerConnectionProcessor extends Thread{

    private Socket socket;//сокет соединения
    private Orders<?> orders;//заказы

    public ServerConnectionProcessor(Orders<?> orders, Socket socket){
        this.orders = orders;
        this.socket = socket;
    }

    public ServerConnectionProcessor(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        /*try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            Orders<?> new_orders = (Orders) inputStream.readObject();
            int port = inputStream.readInt();
            for (var item : new_orders.getList()){
                synchronized (orders){
                    orders.offer(item.getCart(), item.getCredentials(), socket.getLocalAddress(), port);
                }
            }*/
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            ObjectInputStream inputStream = new ObjectInputStream(dis);
            Orders new_orders = (Orders) inputStream.readObject();
            orders = new_orders;
            orders.show();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
