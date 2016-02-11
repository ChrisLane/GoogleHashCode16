package com.godgodgodgo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private BufferedReader reader;

    private List<Product> products;

    public Loader(String filePath) {
        products = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            readParameters();
            readProducts();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String[] getNextLine() {
        try {
            return reader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
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

    /**
     * a line containing the following natural number:
     * ○ P​     * ­ the number of different product types available in warehouses ( 1  ≤ P   ≤ 1 0000)
     * ● a   line   containing   ​
     * P   natural   numbers   separated   by   single   spaces   denoting   weights   of   subsequent
     * products   types,   from   product   type   0   to   product   type   ​
     * P   ­   1.   For   each   weight,
     * <p>
     * <p>
     * 1   ≤ w eight  ≤ m aximum load of  a drone
     */
    private void readProducts() {
        String[] nextLine = getNextLine();
        int productCount = Integer.parseInt(nextLine[0]);

        String[] productsLine = getNextLine();
        for (String product : productsLine)
            products.add(new Product(Integer.parseInt(product)));
    }
}
