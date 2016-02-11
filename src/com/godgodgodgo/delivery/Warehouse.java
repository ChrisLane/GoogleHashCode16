package com.godgodgodgo.delivery;

import java.awt.*;
import java.util.HashMap;

public class Warehouse {
    private Point location;
    private int id;
    /**
     * Key is product id, value is amount
     */
    private HashMap<Integer, Integer> products;

    public Warehouse(Point location, int id) {
        this.location = location;
        this.id = id;
        this.products = new HashMap<>();
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "location=" + location +
                ", id=" + id +
                ", products=" + products +
                '}';
    }
}
