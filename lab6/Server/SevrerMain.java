package ru.eltex.app.lab6.Server;

import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab4.CheckDone;
import ru.eltex.app.lab4.CheckTime;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ServerCloneException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Класс сервера для подклбчения клиентов
 */

public class SevrerMain {
    private static final int PORTTCP = 5555; //Порт для подключения по TCP

    public static void main(String[] args) {

        UDP udp = new UDP(PORTTCP, "127.0.0.255", 9999, 8888);
        udp.start();




//        ExecutorService executeIt = Executors.newFixedThreadPool(2);
//        Orders orders = new Orders();
//        CheckDone doneThread1 = new CheckDone(orders);
//        CheckTime waitThread1 = new CheckTime(orders);
//        Thread doneThread = new Thread(doneThread1);
//        Thread waitThread = new Thread(waitThread1);
//        waitThread.start();
        try (ServerSocket serverSocket = new ServerSocket(PORTTCP)){
            while (true){
                Socket s = serverSocket.accept();
                ServerConnectionProcessor p = new ServerConnectionProcessor(s);
                p.start();
            }
           // Thread.sleep(600);
        /*}catch (InterruptedException e){
            e.printStackTrace();
        }*/
       /* doneThread.start();
        UDPAlret udpAlert = new UDPAlret(PORT, "127.0.0.255");
        udpAlert.start();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true){
                executeIt.execute(new ThreadMain(orders, serverSocket.accept()));
            }*/
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
