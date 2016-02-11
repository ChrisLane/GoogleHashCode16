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

    private Command(Drone drone, CommandType type) {
        this.drone = drone;
        this.type = type;
        // no constructor 4 u
    }

    public static Command createDeliverCommand(Drone drone, Order order, Payload payload) {
        Command cmd = new Command(drone, CommandType.LOAD);
        cmd.setOrder(order);
        cmd.setPayload(payload);

        return cmd;
    }

    public static Command createLoadCommand(Drone drone, Warehouse warehouse, Payload payload) {
        Command cmd = new Command(drone, CommandType.LOAD);
        cmd.setWarehouse(warehouse);
        cmd.setPayload(payload);

        return cmd;
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

    @Override
    public String toString() {
        return String.format("%d %s %d %d %d",
                drone.getID(),
                type.name().charAt(0),
                type != CommandType.LOAD ? warehouse.getID() : order.getID(),
                payload.getProduct().getID(),
                payload.getCount()
        );
    }
}
