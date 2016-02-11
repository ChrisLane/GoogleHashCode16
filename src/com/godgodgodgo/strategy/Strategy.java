package com.godgodgodgo.strategy;

import com.godgodgodgo.Loader;

public abstract class Strategy {

    protected Loader loader;

    public Strategy(Loader loader) {
        this.loader = loader;
    }

    public abstract StrategyOutput execute();
}
