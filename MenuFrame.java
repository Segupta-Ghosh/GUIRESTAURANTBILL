package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MenuFrame extends JFrame {
    private Menu menu;
    private Customer customer;

    public MenuFrame() {
        setTitle("Restaurant Menu");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu = new Menu();
        customer = new Customer();
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i + 1);
            model.addElement((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
        }

        JList<String> itemList = new JList<>(model);
        add(new JScrollPane(itemList), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        JTextField qtyField = new JTextField();
        JButton addBtn = new JButton("Add Item");
        JButton billBtn = new JButton("Generate Bill");

        panel.add(new JLabel("Quantity:"));
        panel.add(qtyField);
        panel.add(addBtn);
        panel.add(billBtn);

        add(panel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            int index = itemList.getSelectedIndex();
            if (index >= 0) {
                try {
                    int qty = Integer.parseInt(qtyField.getText());
                    MenuItem item = menu.getItem(index + 1);
                    customer.addOrder(item, qty);
                    JOptionPane.showMessageDialog(this, "Item added!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Select an item first.");
            }
        });

        billBtn.addActionListener(e -> {
            customer.generateBill();
            JOptionPane.showMessageDialog(this, "Bill generated and saved to bill.txt!");
        });

        setVisible(true);
    }
}
