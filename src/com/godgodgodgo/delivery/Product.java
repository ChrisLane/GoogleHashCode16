package com.godgodgodgo.delivery;

public class Product {
    private int id;
    private int weight;

    public Product(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getID() {
        return id;
    }
}
