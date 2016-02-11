package com.godgodgodgo.delivery;

import com.godgodgodgo.Parameters;

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

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getDistanceToDestination() {
        return (int) Math.ceil(warehouse.getLocation().distance(destination));
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

    public boolean canCarry(Product product) {
        Integer currentWeight = payload.stream().reduce(0, (acc, x) -> acc + x.getProduct().getWeight(), (a, b) -> a + b);
        return currentWeight + product.getWeight() <= Parameters.MAX_LOAD;
    }

    public Payload load(Product product) {
        Payload p = new Payload(product, 1);
        payload.add(p);
        return p;
    }
}