package com.godgodgodgo;

import java.awt.*;
import java.util.HashMap;

public class Warehouse {
    private Point location;
    /**
     * Key is product id, value is amount
     */
    private HashMap<Integer, Integer> products;

    public Warehouse(Point location, HashMap<Integer, Integer> products) {
        this.location = location;
        this.products = products;
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.products = products;
    }
}
