package ru.eltex.app.lab6.Server;

import java.io.IOException;
import java.net.*;

/**
 * Класс рассылающий номер порта для соединения TCP по UDP
 */
public class UDP extends Thread {
    private byte[] buffer; //байтовый массив
    private String address;
    private int localPort;
    private int reserveport;
    private volatile boolean fRun;

   /* public UDP(Integer address, String broadcast){
        this.buffer = address.toString().getBytes();
        this.fRun = true;
        this.address = broadcast;
    }*/


   public UDP (Integer portTransfer, String address, int port1, int port2){
       this.buffer = portTransfer.toString().getBytes();
       this.address = address;
       this.localPort = port1;
       this.reserveport = port2;
       this.fRun = true;
   }

    /**
     * Выключение потока
     */
    public void Off(){
        fRun = false;
    }


    @Override
    public void run(){
        super.run();
        while (fRun){
            try (DatagramSocket datagram = new DatagramSocket()){
                DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(address), localPort);
                datagram.send(packet1);
                DatagramPacket packet2 =  new DatagramPacket(buffer, buffer.length, InetAddress.getByName(address), reserveport);
                datagram.send(packet2);
            }catch (SocketException ex){
                ex.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            /*try {
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }*/
        }
    }
}
