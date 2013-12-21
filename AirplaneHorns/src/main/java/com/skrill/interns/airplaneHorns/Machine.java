package com.skrill.interns.airplaneHorns;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;

import com.skrill.interns.airplaneHornsClientServer.Client;

public abstract class Machine implements Runnable {
    protected int productionTime;
    protected int firstPart;
    protected int secondPart;
    protected int producedPart;
    protected List<Station> stations;
    protected String name;
    protected Client airplaneHornsClient;
    protected static Random rand = new Random();

    public Machine(List<Station> stations, int productionTime, String name) throws IllegalArgumentException,
            SocketException, UnknownHostException {
        if (stations == null) {
            throw new IllegalArgumentException();
        }
        this.stations = stations;
        this.productionTime = productionTime;
        this.name = name;
        this.firstPart = 0;
        this.secondPart = 0;
        this.producedPart = 0;
        this.airplaneHornsClient = Client.getInstance();
    }

    public void addFirstPart(int firstPart) {
        if (firstPart >= 0) {
            this.firstPart += firstPart;
        }
    }

    public void addSecondPart(int secondPart) {
        if (secondPart >= 0) {
            this.secondPart += secondPart;
        }
    }

    public void addProducedPart(int producedPart) {
        if (producedPart >= 0) {
            this.producedPart += producedPart;
        }
    }

    public void removeFirstPart(int firstPart) {
        if (firstPart >= 0) {
            this.firstPart -= firstPart;
        }
    }

    public void removeSecondPart(int secondPart) {
        if (secondPart >= 0) {
            this.secondPart -= secondPart;
        }
    }

    public void removeProducedPart(int producedPart) {
        if (producedPart >= 0) {
            this.producedPart -= producedPart;
        }
    }

    abstract void produce();

    abstract boolean checkIfReadyToProduce();

    abstract void load(Station station);

    abstract void unload(Station station);

    public void run() {
        while (true) {
            int numberOfStations = stations.size();
            Station station = stations.get(rand.nextInt(numberOfStations));
            load(station);
            if (checkIfReadyToProduce()) {
                produce();
                unload(station);

            }
        }
    }
}
