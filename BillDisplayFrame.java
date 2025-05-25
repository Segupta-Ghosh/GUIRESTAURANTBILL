package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;

public class BillDisplayFrame extends JFrame {

    public BillDisplayFrame(String billText) {
        setTitle("Customer Bill");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(billText);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
