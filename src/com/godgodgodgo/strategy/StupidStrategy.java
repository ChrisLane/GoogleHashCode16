package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;
import com.godgodgodgo.delivery.Order;
import com.godgodgodgo.delivery.Product;
import com.godgodgodgo.delivery.Warehouse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StupidStrategy extends Strategy {
    public StupidStrategy(Loader loader) {
        super(loader);
    }

    @Override
    public void begin() {
        List<Order> orders = loader.getOrders();
        Map<Warehouse, List<Order>> possibleOrders = new LinkedHashMap<>();

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

        possibleOrders.entrySet().stream().forEach((x) -> System.out.println(x.getKey().getID() + " -> " + x.getValue().size()));

    }

    @Override
    public boolean tick() {
        return true;
    }

    @Override
    public StrategyOutput terminate() {
        // find all the orders that can be satisifed by just warehouse 0
        // send n drones to do them all
        // stahp
        System.exit(0);
        return null;
    }


    private boolean canBeSatisfiedByWarehouse(Warehouse warehouse, Order order) {

        for (Product product : order.getProducts())
            if (warehouse.getProducts().get(product.getID()) == 0)
                return false;
        return true;

    }
}
