package com.godgodgodgo;


import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Order {
    private Point pos;
    private List<Product> products;

    public Order(Point pos) {
        this.pos = pos;
        this.products = new ArrayList<>();
    }

    public Point getPosition() {
        return pos;
    }

    public List<Product> getProducts() {
        return products;
    }
}
