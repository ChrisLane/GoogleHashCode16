package com.godgodgodgo;

import java.awt.*;
import java.util.HashMap;

public class Warehouse {
    private Point location;
    /**
     * Key is product id, value is amount
     */
    private HashMap<Integer, Integer> products;

    public Warehouse(Point location) {
        this.location = location;
        this.products = new HashMap<>();
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }
}
