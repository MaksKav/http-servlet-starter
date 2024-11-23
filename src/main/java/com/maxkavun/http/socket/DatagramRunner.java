package com.maxkavun.http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramRunner {
    /*Фактически это КЛИЕНТ который работает по протоколу UDP*/
    public static void main(String[] args) throws IOException {
        var inetAddress = InetAddress.getByName("localhost");
        try (var datagramSocket = new DatagramSocket()) {
             var bytes = "Hello from UDP client!".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length , inetAddress, 7777);
            datagramSocket.send(packet);
        }
    }
}
