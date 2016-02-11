package com.godgodgodgo;

import com.godgodgodgo.delivery.Drone;
import com.godgodgodgo.delivery.Order;
import com.godgodgodgo.delivery.Product;
import com.godgodgodgo.delivery.Warehouse;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private BufferedReader reader;

    private List<Product> products;
    private List<Warehouse> warehouses;
    private List<Order> orders;
    private List<Drone> drones;

    public Loader(String filePath) {
        products = new ArrayList<>();
        warehouses = new ArrayList<>();
        orders = new ArrayList<>();
        drones = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            readParameters();
            readProducts();
            readWarehouses();
            readOrders();

            createDrones();

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
            return new String[0];
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

        System.out.println("Parameters.ROW_COUNT = " + Parameters.ROW_COUNT);
        System.out.println("Parameters.COL_COUNT = " + Parameters.COL_COUNT);
        System.out.println("Parameters.DRONE_COUNT = " + Parameters.DRONE_COUNT);
        System.out.println("Parameters.DEADLINE = " + Parameters.DEADLINE);
        System.out.println("Parameters.MAX_LOAD = " + Parameters.MAX_LOAD);
    }

    private void createDrones() {
        drones = new ArrayList<>();
        for (int i = 0; i < Parameters.DRONE_COUNT; i++)
            drones.add(new Drone(warehouses.get(0)));

        System.out.printf("Created %d drones\n", this.drones.size());
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
        getNextLine(); // ignore count
        String[] productsLine = getNextLine();
        for (int i = 0, productsLineLength = productsLine.length; i < productsLineLength; i++) {
            products.add(new Product(i, Integer.parseInt(productsLine[i])));
        }
        System.out.printf("Found %d products\n", products.size());
    }

    private void readWarehouses() {
        String[] countLine = getNextLine();
        int warehouseCount = Integer.parseInt(countLine[0]);

        for (int i = 0; i < warehouseCount; i++) {
            String[] posLine = getNextLine();
            int row = Integer.parseInt(posLine[0]);
            int col = Integer.parseInt(posLine[1]);

            Warehouse warehouse = new Warehouse(new Point(row, col));

            String[] productsLine = getNextLine();
            for (int prod = 0; prod < products.size(); prod++)
                warehouse.getProducts().put(prod, Integer.parseInt(productsLine[prod]));

            warehouses.add(warehouse);
        }

        System.out.printf("Found %d warehouses\n", warehouses.size());
    }

    private void readOrders() {
        int count = Integer.parseInt(getNextLine()[0]);

        for (int i = 0; i < count; i++) {
            String[] posLine = getNextLine();
            int row = Integer.parseInt(posLine[0]);
            int col = Integer.parseInt(posLine[1]);

            Order order = new Order(new Point(row, col));

            getNextLine(); // unused count

            String[] productsLine = getNextLine();
            for (String product : productsLine) {
                int p = Integer.parseInt(product);
                order.getProducts().add(products.get(p));
            }

            orders.add(order);

        }

        System.out.printf("Found %d orders\n", orders.size());

    }
}
