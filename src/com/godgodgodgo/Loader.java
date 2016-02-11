package com.godgodgodgo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Loader {

    private BufferedReader reader;

    public Loader(String filePath) {

        try {
            reader = new BufferedReader(new FileReader(filePath));
            readParameters();


            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String[] getNextLine() {
        try {
            return reader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * number of rows in the area of the simulation  ( 1  ≤ n umber of  rows  ≤ 1 0000)
     * number of columns in the area of the simulation  ( 1  ≤ n umber of  columns  ≤ 1 0000)
     * D ­ number of drones available  ( 1  ≤ D   ≤ 1 000)
     * deadline of the simulation  ( 1  ≤ d eadline of  the simulation  ≤ 1 000000)
     * maximum load of a drone  ( 1  ≤ m aximum load of  a drone  ≤ 1 0000)
     */
    private void readParameters() {
        String[] firstLine = getNextLine();

        Parameters.ROW_COUNT = Integer.parseInt(firstLine[0]);
        Parameters.COL_COUNT = Integer.parseInt(firstLine[1]);
        Parameters.DRONE_COUNT = Integer.parseInt(firstLine[2]);
        Parameters.DEADLINE = Integer.parseInt(firstLine[3]);
        Parameters.MAX_LOAD = Integer.parseInt(firstLine[4]);
    }
}
