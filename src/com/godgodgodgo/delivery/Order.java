package com.godgodgodgo.delivery;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "Order{" +
                "pos=" + pos +
                ", products=" + products +
                ", id=" + id +
                '}';
    }
}
