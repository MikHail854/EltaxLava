package ru.eltex.app.lab6.Client;


import ru.eltex.app.lab2.Credentials;
import ru.eltex.app.lab2.Order;
import ru.eltex.app.lab2.Orders;
import ru.eltex.app.lab4.Generator;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * Класс для работы с сервером и заказами
 */

public class ClientMain {
    private int PORT = 9999;//порт прослушивания основной
    private int acceptport;//свободный порт для получения подтверждения
    private int portTCP;//порт на установку TCP соединения
    private InetAddress address;//адресс отправки по TCP
    private Credentials user;//информация о пользователе
    private Orders<?> orders;//заказы
    private DatagramSocket socket;

    private ClientMain(Credentials user, Orders<?> orders){
        this.user = user;
        this.orders = orders;
        this.acceptport = 0;
    }

    public static void main(String[] args) {
        Orders<Order> orders = new Orders();
        Credentials user = new Credentials("Анна","Старкова","Свергеевна", "annastarko@yandex.ru");

        Generator generate = new Generator (user, orders);
        generate.start();

        ClientMain clientMain = new ClientMain(user, orders);
        while (true) {
            //clientMain.udpReceivePort();
//            clientMain.sendTCP();
//            generate.setWait();
//            clientMain.udpReceiveAccept();
//            synchronized (generate){
//                generate.notify();
//            }
            clientMain.ReceiverAlertUDP();
            clientMain.ConnectTCP();
            generate.Waiting();

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Получить порт на отправку
     */
    public void ReceiverAlertUDP (){
        //byte[] buf = new byte[255];
        DatagramPacket packet = new DatagramPacket(new byte[255], 1024);
        try{
            socket = new DatagramSocket(PORT);
        }catch (SocketException e){
                e.printStackTrace();
        }
        System.out.println("Ждем на порту " + socket.getLocalPort());
        try {
            socket.receive(packet);
        }catch (IOException e){
            e.printStackTrace();
        }
        byte[] data = packet.getData();
        String s = new String(data, 0, packet.getLength());
        portTCP = Integer.parseInt(s);

        System.out.println("Порт из оповещение UDP: " + portTCP);
        address = packet.getAddress();
        socket.close();
    }

    /**
     * Получение подтверждения
     */
    public void AcceptAlertUDP(){
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        try (DatagramSocket socket = new DatagramSocket(acceptport)){
            System.out.println("Ждем подтверждение на порту " + acceptport + "...");
            socket.receive(packet);
        }catch (SocketException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Время обработки заказа: " + received);
        System.out.println("Получили подтверждение...");
    }

    /**
     * Отправить заказы по TCP
     */

    public void ConnectTCP(){
        try (Socket socket = new Socket(address, portTCP)) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(dos);
            this.acceptport = socket.getLocalPort();
            System.out.println("Localport: " + acceptport);
            outputStream.writeObject(orders);
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
