package com.maxkavun.http.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    private final int PORT ;

    public HttpServer(int PORT) {
        this.PORT = PORT;
    }

    public void run(){
        try (var serverSocket = new ServerSocket(PORT)) {
            //метод accept() блокирующий  , он блокирует нам поток пока кто-то не пришлет запрос
           var socket =  serverSocket.accept();
           processSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
