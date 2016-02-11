package com.godgodgodgo.strategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StrategyOutput {

    private List<Command> commands;
    private int timeStep;
    private int dronesUsed;

    public StrategyOutput(List<Command> commands, int timeStep, int dronesUsed) {
        this.commands = commands;
        this.timeStep = timeStep;
        this.dronesUsed = dronesUsed;
    }


    public void export(String file) {

        File out = new File(file);
        if (out.exists())
            out.delete();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(Integer.toString(timeStep * dronesUsed));

            commands.stream().forEachOrdered(c -> {
                try {
                    writer.write("\n");
                    writer.write(c.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Wrote to %s\n", file);

    }
}
