package com.maxkavun.http.client;

import java.io.IOException;
import java.net.URL;

public class UrlExample {
    public static void main(String[] args) throws IOException {
      var url = new URL("file:C:\\Users\\Maks\\IdeaProjects\\TestProjects\\http-servlets-starter\\src\\main\\java\\com\\maxkavun\\http\\socket\\DatagramRunner.java");
      var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        var url =  new URL("https://www.google.com");
        var urlConnection = url.openConnection();

        try (var outputStream = urlConnection.getOutputStream()) {

        }

        System.out.println();
    }
}
