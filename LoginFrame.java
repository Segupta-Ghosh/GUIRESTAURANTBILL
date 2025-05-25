package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        add(new JLabel("Username:"));
        add(userField);
        add(new JLabel("Password:"));
        add(passField);

        JPanel panel = new JPanel();
        panel.add(loginBtn);
        panel.add(registerBtn);
        add(panel);

        loginBtn.addActionListener(e -> {
            if (LoginSystem.login(userField.getText(), new String(passField.getPassword()))) {
                dispose();
                new MenuFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed");
            }
        });

        registerBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (LoginSystem.register(user, pass)) {
                JOptionPane.showMessageDialog(this, "Registration successful");
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed");
            }
        });

        setVisible(true);
    }
}
