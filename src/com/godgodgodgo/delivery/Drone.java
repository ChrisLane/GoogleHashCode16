package com.godgodgodgo.delivery;

import java.awt.*;

public class Drone {
    public final int capacity;
    int payload;
    Point destination;

    public Drone(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

}