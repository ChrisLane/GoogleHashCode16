package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;
import com.godgodgodgo.delivery.Payload;

import java.util.Collections;

public class StupidStrategy extends Strategy {
    public StupidStrategy(Loader loader) {
        super(loader);
    }

    @Override
    public void begin() {
    }

    @Override
    public boolean tick() {
        return true;
    }

    @Override
    public StrategyOutput terminate() {
        return new StrategyOutput(Collections.singletonList(
                Command.createDeliverCommand(loader.getDrones().get(0), loader.getOrders().get(0), new Payload(loader.getProducts().get(0), 10))
        ), 1, 1);
    }

}
