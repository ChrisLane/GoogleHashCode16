package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;

public abstract class Strategy {

    protected Loader loader;

    public Strategy(Loader loader) {
        this.loader = loader;
    }

    public abstract void begin();

    public abstract void tick();

    public abstract boolean isDone();

    public abstract StrategyOutput terminate();
}
