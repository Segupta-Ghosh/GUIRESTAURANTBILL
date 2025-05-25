package com.mycompany.gui;

import java.io.*;
import java.util.*;

public class Customer {
    private List<OrderItem> orderList;

    public Customer() {
        orderList = new ArrayList<>();
    }

    public void addOrder(MenuItem item, int quantity) {
        orderList.add(new OrderItem(item, quantity));
    }

    public String generateBill() {
        double grandTotal = 0;
        StringBuilder bill = new StringBuilder();
        bill.append("------ BILL ------\n");
        bill.append(String.format("%-15s %-5s %-7s %-7s%n", "Item", "Qty", "Price", "Total"));

        for (OrderItem order : orderList) {
            double total = order.getTotal();
            grandTotal += total;
            bill.append(String.format("%-15s %-5d %-7.2f %-7.2f%n",
                order.getItem().getName(), order.getQuantity(), order.getItem().getPrice(), total));
        }

        bill.append("-------------------\n");
        bill.append(String.format("GRAND TOTAL: %.2f\n", grandTotal));

        try (FileWriter fw = new FileWriter("bill.txt")) {
            fw.write(bill.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bill.toString();
    }
}
