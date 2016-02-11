package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;

public abstract class Strategy {

    protected Loader loader;
    protected int tickCount;

    public Strategy(Loader loader) {
        this.loader = loader;
        this.tickCount = 0;
    }

    public abstract void begin();

    /**
     * @return True when done
     */
    public abstract boolean tick();

    public abstract StrategyOutput terminate();
}
