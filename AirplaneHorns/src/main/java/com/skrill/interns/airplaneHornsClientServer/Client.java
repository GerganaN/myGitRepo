package com.skrill.interns.airplaneHornsClientServer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int PORT = 2222;

    private static DatagramSocket clientSocket;
    private static InetAddress serverIpAddress;
    private static byte[] sendedData;
    private static Client instance = null;

    public static synchronized Client getInstance() throws SocketException, UnknownHostException {
        clientSocket = new DatagramSocket();
        serverIpAddress = InetAddress.getByName(SERVER_HOST);
        sendedData = new byte[100];
        if (instance == null) {
            clientSocket = new DatagramSocket();
            serverIpAddress = InetAddress.getByName(SERVER_HOST);
            sendedData = new byte[100];
            instance = new Client();
        }
        return instance;
    }

    private Client() {
    }

    public synchronized void sendToServer(String message) {
        try {
            sendedData = message.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(sendedData, sendedData.length, serverIpAddress, PORT);
            clientSocket.send(sendPacket);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The named encoding is not supported");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Sorry, your message has not been send");
            e.printStackTrace();
        }
    }

    protected void finalize() {
        clientSocket.close();
    }
}
