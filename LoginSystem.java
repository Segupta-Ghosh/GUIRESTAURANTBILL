package com.mycompany.gui;

import java.io.*;
import java.util.*;

public class LoginSystem {
    private static final String USER_FILE = "users.txt";

    public static boolean register(String username, String password) {
        try (FileWriter fw = new FileWriter(USER_FILE, true)) {
            fw.write(username + "," + password + "\n");
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean login(String inputUsername, String inputPassword) {
        try (Scanner fileScanner = new Scanner(new File(USER_FILE))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts.length == 2) {
                    if (parts[0].equals(inputUsername) && parts[1].equals(inputPassword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
