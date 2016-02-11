package com.godgodgodgo.delivery;


import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Order {
    private Point pos;
    private List<Product> products;
    private int id;

    public Order(Point pos, int id) {
        this.pos = pos;
        this.products = new ArrayList<>();
        this.id = id;
    }

    public Point getPosition() {
        return pos;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getID() {
        return id;
    }
}
