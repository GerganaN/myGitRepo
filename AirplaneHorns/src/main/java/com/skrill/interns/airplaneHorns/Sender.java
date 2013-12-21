package com.skrill.interns.airplaneHorns;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import com.skrill.interns.airplaneHornsClientServer.Client;

public class Sender implements Runnable {
    private List<Station> stations;
    private Client airplaneHornsClient;

    public Sender(List<Station> stations) throws SocketException, UnknownHostException {
        this.stations = stations;
        this.airplaneHornsClient = Client.getInstance();
    }

    @Override
    public void run() {
        Station currentStation;
        int amountPartE;
        while (true) {
            for (int i = 0; i < stations.size(); i++) {
                currentStation = stations.get(i);
                if (currentStation.getPartE() > 0) {
                    amountPartE = currentStation.getPartE();
                    currentStation.removePartE(amountPartE);
                    System.out.println(currentStation.getName() + " sends " + amountPartE + " P_E");
                    airplaneHornsClient.sendToServer(currentStation.getName() + " sends " + amountPartE + " P_E");
                }
            }
        }
    }

}
