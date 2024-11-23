package com.maxkavun.http.skj;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Closeable {
    private Socket socket;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public void sendMessage(String message) throws IOException {
        byte[] buffer = message.getBytes();
        try {
            OutputStream os = socket.getOutputStream();
            os.write(buffer);
            os.flush();
        } catch (Exception e) {
            System.out.println("Error while sending message: " + e.getMessage());
        }
    }

    public String getMessage() throws IOException {
        socket.setSoTimeout(2000);  // Устанавливаем тайм-аут
        byte[] buffer = new byte[1];
        StringBuilder message = new StringBuilder();

        try {
            InputStream is = socket.getInputStream();

            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                String c = new String(buffer, 0, bytesRead);
                if (c.equals("\n")) {
                    break;
                }
                message.append(c);
            }
        } catch (java.net.SocketTimeoutException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
        return message.toString();
    }

    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
