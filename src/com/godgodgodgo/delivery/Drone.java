package com.godgodgodgo.delivery;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drone {
    private Point destination;
    private List<Payload> payload;
    private int id;
    private Warehouse warehouse;

    public Drone(int id, Warehouse warehouse) {
        this.id = id;
        this.warehouse = warehouse;
        payload = new ArrayList<>();
    }

    public int getID() {
        return id;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
        // todo something
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "destination=" + destination +
                ", payload=" + payload +
                ", id=" + id +
                ", warehouse=" + warehouse +
                '}';
    }
}