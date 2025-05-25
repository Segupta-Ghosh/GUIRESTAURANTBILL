package com.mycompany.gui;

public class MenuItem extends Item {
    private double price;

    public MenuItem(String name, double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
