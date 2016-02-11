package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;
import com.godgodgodgo.Parameters;
import com.godgodgodgo.delivery.*;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<Warehouse, ArrayDeque<Order>> possibleOrders = getWarehouseSatisfactionafiers();
        // todo sort by order distance with priorty queue and comparator
        for (int timeTick = 0; timeTick < Parameters.DEADLINE; timeTick++) {

            for (Drone drone : loader.getDrones()) {
                if (!drone.hasArrived(timeTick))
                    continue;

                List<Warehouse> closestWarehouses = findClosestWarehouse(drone);

                if (closestWarehouses.isEmpty())
                    break;

                Order order = null;

                for (Warehouse warehouse : closestWarehouses) {
                    if (order != null)
                        break;

                    order = possibleOrders.get(warehouse).poll();

                }

                if (order == null)
                    break;


                Payload payload = decideOnPayload(drone, order);

                if (payload == null) {
                    continue;
                }

//                int currentDistance = 1;
                Warehouse closestWarehouse = closestWarehouses.get(0);
                Command loadCommand = Command.createLoadCommand(drone, closestWarehouse, payload);
                drone.setWarehouse(closestWarehouse);

                commands.add(loadCommand);
                startTime.put(loadCommand, timeStep);

                Command deliverCommand = Command.createDeliverCommand(
                        drone, order, payload
                );
                drone.setDestination(order.getPosition());
                commands.add(deliverCommand);
                startTime.put(deliverCommand, timeStep);

//                currentDistance += drone.getDistanceToDestination();
//                maxDistance = Math.max(currentDistance, maxDistance);


            }


        }


//        commands.sort((o1, o2) -> o1.getType().compareTo(o2.getType()));


    }

    private List<Warehouse> findClosestWarehouse(Drone drone) {

        ArrayList<Warehouse> warehouses = new ArrayList<>(loader.getWarehouses());
        warehouses.sort(
                (o1, o2) -> Double.valueOf(o1.getLocation().distance(drone.getDestination())).compareTo(o2.getLocation().distance(drone.getDestination()))
        );

        // eurgh
        int size = warehouses.size();
        List<Warehouse> collect = warehouses.stream().filter(
                w -> w.getProducts().values().stream().anyMatch(x -> x > 0)).collect(Collectors.toList());


        return collect;
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
    private Map<Warehouse, ArrayDeque<Order>> getWarehouseSatisfactionafiers() {
        Map<Warehouse, ArrayDeque<Order>> possibleOrders = new LinkedHashMap<>();

        List<Order> orders = loader.getOrders();
        for (Order order : orders) {

            loader.getWarehouses()
                    .stream()
                    .filter(warehouse -> canBeSatisfiedByWarehouse(warehouse, order))
                    .forEach(warehouse -> {
                        ArrayDeque<Order> current = possibleOrders.getOrDefault(warehouse, new ArrayDeque<>());
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
