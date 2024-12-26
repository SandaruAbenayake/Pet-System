/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thepawsshop.thepawsshop.models;

/**
 *
 * @author User
 */
public class Item {
    
      // Private fields to encapsulate the data
    private String name;
    private String category;
    private double price;
    private int quantity;

    // Constructor to initialize the object
    public Item(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Public getter and setter methods to provide controlled access

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) { // Validation to ensure price is positive
            this.price = price;
        } else {
            System.out.println("Price must be positive.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) { // Validation to ensure quantity is not negative
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative.");
        }
    }
    
     @Override
    public String toString() {
        // Save in comma-separated format
        return name + "," + category + "," + price + "," + quantity;
    }
    
    
    public static Item fromString(String itemData) {
        String[] parts = itemData.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid item data format.");
        }
        String name = parts[0].trim();
        String category = parts[1].trim();
        double price = Double.parseDouble(parts[2].trim());
        int quantity = Integer.parseInt(parts[3].trim());

        return new Item(name, category, price, quantity);
    }



    
}
