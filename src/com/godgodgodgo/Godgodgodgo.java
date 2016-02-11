package com.godgodgodgo;

import com.godgodgodgo.strategy.Strategy;
import com.godgodgodgo.strategy.StrategyOutput;
import com.godgodgodgo.strategy.StupidStrategy;

public class Godgodgodgo {
    public static void main(String[] args) {
        Loader loader = new Loader("res/busy_day.in");

        Strategy strategy;
        strategy = new StupidStrategy(loader);

        System.out.println("Starting strategy...oh dear");
        StrategyOutput output = strategy.execute();
        output.export("busy_day.out");

        System.out.println("All done!");
    }
}
