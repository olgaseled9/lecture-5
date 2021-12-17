package by.itacademy.javaenterprise.seledtsova.servlets;


import by.itacademy.javaenterprise.seledtsova.utils.IPReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static by.itacademy.javaenterprise.seledtsova.utils.MACReader.getMacAddress;

public class FirstServlet extends HttpServlet {

    AtomicLong requestCount = new AtomicLong(0);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String ipAddress = IPReader.getIP(request);

        requestCount.incrementAndGet();

        out.println("Server IP: " + request.getLocalAddr());
        out.println("Client IP: " + ipAddress);
        out.println("MAC client: " + getMacAddress());
        out.println("Content-type: " + request.getContentType());
        out.println("Request URL: " + request.getRequestURL());
        out.println("Count of request: " + requestCount);
        out.println("Number of thread: " + Thread.currentThread().getName());
        out.println("LocalHost: " + NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));
        out.println("PathInfo: " + request.getPathInfo());
        out.println("Cookies: " + Arrays.toString(request.getCookies()));
        out.println(LocalDateTime.now());
    }
}

