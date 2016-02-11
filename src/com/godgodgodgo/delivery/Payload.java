package com.godgodgodgo.delivery;

public class Payload {
    private Product product;
    private int count;

    public Payload(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }
}
