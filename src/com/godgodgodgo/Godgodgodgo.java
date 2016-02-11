package com.godgodgodgo;

import com.godgodgodgo.strategy.Strategy;
import com.godgodgodgo.strategy.StrategyOutput;
import com.godgodgodgo.strategy.StupidStrategy;

public class Godgodgodgo {
    public static void main(String[] args) {
        String name = "busy_day";
        String inFile = "res/" + name + ".in";
        String outFile = name + ".out";



        Loader loader = new Loader(inFile);

        Strategy strategy;
        strategy = new StupidStrategy(loader);

        System.out.println("Starting strategy...oh dear");
        strategy.begin();

        for (int i = 0; i < Parameters.DEADLINE; i++) {
            if (strategy.tick())
                break;
        }

        StrategyOutput output = strategy.terminate();
        output.export(outFile);

        System.out.println("All done!");
    }
}
