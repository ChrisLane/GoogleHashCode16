package com.godgodgodgo.strategy;

import com.godgodgodgo.delivery.Drone;
import com.godgodgodgo.delivery.Order;
import com.godgodgodgo.delivery.Payload;
import com.godgodgodgo.delivery.Warehouse;

enum CommandType {
    LOAD, DELIVER
}

public class Command {

    private Drone drone;
    private CommandType type;

    private Warehouse warehouse;
    private Payload payload;
    private Order order;

    public Command(Drone drone, CommandType type) {
        this.drone = drone;
        this.type = type;
    }

    public Drone getDrone() {
        return drone;
    }

    public CommandType getType() {
        return type;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
