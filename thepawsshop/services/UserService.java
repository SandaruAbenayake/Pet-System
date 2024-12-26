/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thepawsshop.thepawsshop.services;

import com.thepawsshop.thepawsshop.models.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author User
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
   
    final String filePath = "src/main/java/com/thepawsshop/thepawsshop/util/data/user.txt";

    // Save a cashier to the file
   public boolean saveCashier(User cashier) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write(cashier.toString());
        writer.newLine();
        return true; // Return true if the operation succeeds
    } catch (IOException e) {
        System.err.println("Error saving cashier: " + e.getMessage());
        return false; // Return false if an exception occurs
    }
}


    // Load all cashiers from the file
    public List<User> loadUser() {
        List<User> cashiers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    cashiers.add(User.fromString(line));
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing cashier data: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return cashiers;
    }

    // Validate cashier credentials
    public boolean validateCashier(String username, String password) {
        List<User> cashiers = loadUser();
        return cashiers.stream().anyMatch(cashier ->
            cashier.getUsername().equals(username) && cashier.getPassword().equals(password));
    }
}

