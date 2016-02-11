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
        strategy.begin();

        for (int i = 0; i < Parameters.DEADLINE; i++) {
            strategy.tick();
            if (strategy.isDone())
                break;
        }

        StrategyOutput output = strategy.terminate();
        output.export("busy_day.out");

        System.out.println("All done!");
    }
}
