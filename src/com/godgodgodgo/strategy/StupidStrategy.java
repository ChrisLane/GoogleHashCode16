package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;

public class StupidStrategy extends Strategy {
    public StupidStrategy(Loader loader) {
        super(loader);
    }

    @Override
    public void begin() {

    }

    @Override
    public void tick() {

    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public StrategyOutput terminate() {
        return null;
    }

}
