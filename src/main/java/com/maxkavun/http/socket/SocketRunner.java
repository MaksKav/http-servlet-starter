package com.maxkavun.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;
/* Фактически это КЛИЕНТ который работает по протоколу TCP */
public class SocketRunner {
    public static void main(String[] args) throws IOException {

        var inetAddress = Inet4Address.getByName("172.21.40.125");
        try (var socket = new Socket(inetAddress, 15000)) {

            var outputStream = new DataOutputStream(socket.getOutputStream());
            var inputStream = new DataInputStream(socket.getInputStream());
            var scanner = new Scanner(System.in);

            String loginAndPassword = "s30908 BX3YBZbK7y\n";
            outputStream.writeUTF(loginAndPassword);

            while(scanner.hasNextLine()){
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("Response from server: " + inputStream.readUTF());
            }
        }
    }
}
