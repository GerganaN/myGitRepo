package com.skrill.interns.weather;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientConnection extends Thread {

    private Socket connectionSocket;
    private BufferedWriter bufferOutToClient;
    private BufferedReader bufferInFromClient;
    private static List<String> mostSearchedCities;

    static {
        mostSearchedCities = new ArrayList<String>();
        mostSearchedCities.add("SOFIA");
        mostSearchedCities.add("VRACA");
        mostSearchedCities.add("VARNA");
    }

    private void setReadAndWriteBuffers() throws UnsupportedEncodingException, IOException {
        OutputStreamWriter outToClient = new OutputStreamWriter(connectionSocket.getOutputStream(), "UTF-8");
        InputStreamReader inFromClient = new InputStreamReader(connectionSocket.getInputStream(), "UTF-8");
        bufferOutToClient = new BufferedWriter(outToClient);
        bufferInFromClient = new BufferedReader(inFromClient);
    }

    private void respondsToClient() throws IOException, NumberFormatException {
        String receivedCity = bufferInFromClient.readLine().toUpperCase();
        int receivedDays = Integer.parseInt(bufferInFromClient.readLine());
        String sendedMessage;
        if (Server.getCachedForecasts().containsKey(receivedCity)
                && Server.getCachedForecasts().get(receivedCity).containsKey(receivedDays)) {
            sendedMessage = (Server.getCachedForecasts().get(receivedCity)).get(receivedDays);
            System.out.println("Get from cache");
        } else {
            WeatherForecast forecast = new WeatherForecast();
            sendedMessage = forecast.getWeather(receivedCity, receivedDays);
            if (mostSearchedCities.contains(receivedCity)) {
                Map<Integer, String> temp = new HashMap<Integer, String>();
                temp.put(receivedDays, sendedMessage);
                Server.getCachedForecasts().put(receivedCity, temp);
            }
            System.out.println("Get from weather station");
        }
        bufferOutToClient.write(sendedMessage + "\n");
        bufferOutToClient.flush();
        connectionSocket.close();
    }

    private void respondsErrorToClient(String errorMessage) {
        try {
            bufferOutToClient.write(errorMessage + "\n");
            bufferOutToClient.flush();
            connectionSocket.close();
        } catch (IOException e) {
            this.interrupt();
            e.printStackTrace();
        }
    }

    public ClientConnection(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    public void run() {
        try {
            setReadAndWriteBuffers();
            respondsToClient();
        } catch (UnsupportedEncodingException e) {
            respondsErrorToClient("Type of encoding is not supported");
        } catch (IOException e) {
            respondsErrorToClient("There is an error with recieved or sended data");
        } catch (NumberFormatException e) {
            respondsErrorToClient("Incorrect number of days\n");
        }
    }
}
