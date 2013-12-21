package com.skrill.interns.airplaneHornsClientServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static final int PORT = 2222;
    private static DatagramSocket serverSocket;
    private static Map<InetAddress, String> clientNames = new HashMap<InetAddress, String>();
    private static byte[] receivedData = new byte[1024];

    static {
        try {
            clientNames.put(InetAddress.getByName("10.129.2.43"), "SOFIA : ");
            clientNames.put(InetAddress.getByName("10.129.2.55"), "VARNA : ");
            clientNames.put(InetAddress.getByName("10.129.2.10"), "VRACA : ");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void clearReceivedData() {
        for (int i = 0; i < receivedData.length; i++) {
            receivedData[i] = 0;
        }
    }

    public static void main(String[] args) {
        try {
            serverSocket = new DatagramSocket(PORT);
            System.out.println("Waiting for clients.. ");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
                // server receives packet from client
                try {
                    serverSocket.receive(receivePacket);
                } catch (IOException ex) {
                    System.err.println("Packet has not been recieved");
                    ex.printStackTrace();
                }
                String received = new String(receivePacket.getData());
                InetAddress address = receivePacket.getAddress();

                if (clientNames.containsKey(address)) {
                    System.out.println(clientNames.get(address) + received.trim());
                } else {
                    System.out.println(receivePacket.getAddress() + " " + received.trim());
                }
                clearReceivedData();
            }
        } catch (SocketException e) {
            System.err.println("Socket could not been opened");
            e.printStackTrace();
        }
    }
}
