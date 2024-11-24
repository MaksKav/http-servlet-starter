package com.maxkavun.http.servlet;

import com.maxkavun.http.service.FlightService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список перелетов</h1>");
            printWriter.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
                printWriter.write("""
                        <li>
                        <a href="/tickets?flightId=%d">%s />
                        </li>
                        """.formatted(flightDto.getId() , flightDto.getDescription()));
            });
            printWriter.write("</ul>");
        } catch (IOException ioException){
            System.out.println("Exception in doGet method");
            ioException.printStackTrace();
        }
    }
}
