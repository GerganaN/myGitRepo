package com.skrill.interns.airplaneHorns;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import com.skrill.interns.airplaneHornsClientServer.Client;

public class Delivery implements Runnable {
    private final int UNLOADING = 2000;
    private List<Station> stations;
    private Distributors distributor;
    private Client airplaneHornsClient;

    public Delivery(Distributors distributor, List<Station> stations) throws IllegalArgumentException, SocketException,
            UnknownHostException {
        if (distributor == null || stations == null) {
            throw new IllegalArgumentException("Wrong arguments");
        }
        this.distributor = distributor;
        this.stations = stations;
        this.airplaneHornsClient = Client.getInstance();
    }

    protected void chooseDelivery(Station currentStation) {
        switch (distributor) {
        case A: {
            currentStation.addPartA(distributor.quantity());
            System.out.println(currentStation.getName() + " received 200 P_A");
            airplaneHornsClient.sendToServer(currentStation.getName() + " received 200 P_A");
            break;
        }
        case B: {
            currentStation.addPartB(distributor.quantity());
            System.out.println(currentStation.getName() + " received 50 P_B");
            airplaneHornsClient.sendToServer(currentStation.getName() + " received 50 P_B");
            break;
        }
        case C: {
            currentStation.addPartC(distributor.quantity());
            System.out.println(currentStation.getName() + " received 20 P_C");
            airplaneHornsClient.sendToServer(currentStation.getName() + " received 20 P_C");
            break;
        }
        }
    }

    protected boolean findFreeStation() {
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).locker.tryLock()) {
                try {
                    chooseDelivery(stations.get(i));
                    Thread.sleep(UNLOADING); // wait for unloading
                } catch (InterruptedException e) {
                    System.out.println("The distributor stop to deliver");
                    airplaneHornsClient.sendToServer("The distributor stop to deliver");
                } finally {
                    stations.get(i).locker.unlock();
                }
                return true;
            }
        }
        return false;
    }

    protected void waitingForDelivery() {
        try {
            Thread.sleep(distributor.frequency());
        } catch (InterruptedException e) {
            System.out.println("The distributor stop to deliver");
            airplaneHornsClient.sendToServer("The distributor stop to deliver");
        }
    }

    @Override
    public void run() {
        while (true) {
            if (findFreeStation()) {
                waitingForDelivery();
            }
        }
    }
}
