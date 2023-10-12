package org.example.gaeun._0925;

public class Main {
    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.visit(new Mercury());
        spaceShip.visit(new Venus());

    }
}
