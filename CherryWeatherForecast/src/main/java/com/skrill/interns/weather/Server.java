package com.skrill.interns.weather;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

public class Server {

    // private static final int TIMEOUT = 20000;
    private static Map<String, Map<Integer, String>> cachedForecast = new HashMap<String, Map<Integer, String>>();

    public static Map<String, Map<Integer, String>> getCachedForecasts() {
        return cachedForecast;
    }

    public static void main(String[] args) {
        
      //  DateTime now = new DateTime();
      //  System.out.println(now.);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
    
        
        try {
            ServerSocket serverSocket = new ServerSocket(2222);
            // serverSocket.setSoTimeout(TIMEOUT);
            while (true) {
                System.out.println("Wait for client to connect...");
                Socket clientSocket = serverSocket.accept();

                System.out.print("Client has connected!\n");
                ClientConnection newConnection = new ClientConnection(clientSocket);
                newConnection.start();
            }
        } catch (SocketException e) {
            System.err.println("Server could not start!");
            e.printStackTrace();
            // } catch (SocketTimeoutException e) {
            // System.err.println("Could not connect with client in time!");
            // e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
