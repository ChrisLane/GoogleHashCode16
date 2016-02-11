package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;

public class StupidStrategy extends Strategy {
    public StupidStrategy(Loader loader) {
        super(loader);
    }

    @Override
    public StrategyOutput execute() {
        System.out.println(":(");
        return new StrategyOutput();
    }
}
