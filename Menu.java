package com.mycompany.gui;

import java.util.*;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
        items.add(new MenuItem("Burger", 5.00));
        items.add(new MenuItem("Fries", 3.00));
        items.add(new MenuItem("Pizza", 8.00));
        items.add(new MenuItem("Pasta", 7.50));
        items.add(new MenuItem("Soda", 2.00));
    }

    public void displayMenu() {
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    public MenuItem getItem(int index) {
        if (index >= 1 && index <= items.size()) {
            return items.get(index - 1);
        }
        return null;
    }

    public int size() {
        return items.size();
    }
}
