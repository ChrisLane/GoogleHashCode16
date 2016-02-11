package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;
import com.godgodgodgo.Parameters;
import com.godgodgodgo.delivery.*;

import java.util.*;

public class StupidStrategy extends Strategy {
    private List<Command> commands;
    private Map<Command, Integer> startTime;
    private int timeStep;


    public StupidStrategy(Loader loader) {
        super(loader);
        commands = new ArrayList<>();
        startTime = new LinkedHashMap<>();
        timeStep = 0;
    }

    @Override
    public void begin() {
        Map<Warehouse, List<Order>> possibleOrders = getWarehouseSatisfactionafiers();
        // todo sort by order distance with priorty queue and comparator

        // all drones do an order
        int maxDistance = 0;
        Warehouse currentWarehouse = loader.getWarehouses().get(0);
        for (int i = 0; i < Parameters.DRONE_COUNT; i++) {
            Drone drone = loader.getDrones().get(i);
            Order order = possibleOrders.get(currentWarehouse).get(i);

            Payload payload = decideOnPayload(drone, order);
            if (payload != null) {
                int currentDistance = 1;
                // todo issue command
                Command loadCommand = Command.createLoadCommand(drone, currentWarehouse, payload);
                drone.setWarehouse(currentWarehouse);

                commands.add(loadCommand);
                startTime.put(loadCommand, 0);

                Command deliverCommand = Command.createDeliverCommand(
                        drone, order, payload
                );
                drone.setDestination(order.getPosition());
                commands.add(deliverCommand);
                startTime.put(deliverCommand, 0);

                currentDistance += drone.getDistanceToDestination();
                System.out.println("currentDistance = " + currentDistance);
                maxDistance = Math.max(currentDistance, maxDistance);
            }

            // load the drone
            // deliver


        }

        this.timeStep = maxDistance;
        commands.sort(new Comparator<Command>() {
            @Override
            public int compare(Command o1, Command o2) {
                return o1.getType().compareTo(o2.getType());
            }
        });


    }

    private Payload decideOnPayload(Drone drone, Order order) {
        if (order.getProducts().isEmpty())
            return null;

        for (int i = 0; i < order.getProducts().size(); i++) {
            Product product = order.getProducts().get(i);
            if (drone.canCarry(product)) {
                order.getProducts().remove(i);
                return drone.load(product);
                // todo reduce capacity of drone and add payload of 1
            }
        }

        return null;
    }

    // that IS how it's spelt
    private Map<Warehouse, List<Order>> getWarehouseSatisfactionafiers() {
        Map<Warehouse, List<Order>> possibleOrders = new LinkedHashMap<>();

        List<Order> orders = loader.getOrders();
        for (Order order : orders) {

            loader.getWarehouses()
                    .stream()
                    .filter(warehouse -> canBeSatisfiedByWarehouse(warehouse, order))
                    .forEach(warehouse -> {
                        List<Order> current = possibleOrders.getOrDefault(warehouse, new ArrayList<>());
                        current.add(order);
                        possibleOrders.put(warehouse, current);
                    });
        }
        return possibleOrders;
    }

    @Override
    public boolean tick() {
        return true;
    }

    @Override
    public StrategyOutput terminate() {

        return new StrategyOutput(
                commands,
                commands.size(),
                1
        );
    }


    private boolean canBeSatisfiedByWarehouse(Warehouse warehouse, Order order) {

        for (Product product : order.getProducts())
            if (warehouse.getProducts().get(product.getID()) == 0)
                return false;
        return true;

    }
}
