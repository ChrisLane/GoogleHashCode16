package com.godgodgodgo.delivery;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drone {
    private Point destination;
    private List<Payload> payload;
    private Warehouse warehouse;

    public Drone(Warehouse warehouse) {
        this.warehouse = warehouse;
        payload = new ArrayList<>();
    }

    public Point getDestination() {
        return destination;
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
        // todo something
    }
}