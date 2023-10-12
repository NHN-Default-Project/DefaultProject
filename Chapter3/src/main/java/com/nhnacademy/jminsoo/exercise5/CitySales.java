package com.nhnacademy.jminsoo.exercise5;

public class CitySales {

    private final String name;
    private double sales;
    private boolean isReceived;

    public CitySales(String str) {
        int index = str.indexOf(":");
        if (index == -1) {
            throw new IllegalArgumentException("");
        }
        this.name = str.substring(0, index);
        String sales = str.substring(str.indexOf(":") + 1).replaceAll("[^A-Za-z0-9.]", "");

        try {
            Double.parseDouble(sales);
            this.isReceived = true;
            this.sales = Double.parseDouble(sales);

        } catch (NumberFormatException e) {
            this.isReceived = false;
            this.sales = 0;
        }
    }

    public double getSales() {
        if (isReceived) {
            return this.sales;
        } else {
            return 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isReceived() {
        return this.isReceived;
    }
}
