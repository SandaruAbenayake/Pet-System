/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thepawsshop.thepawsshop.models;

public class Category {
    private String name;
    private String description;


    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Public getter and setter methods to provide controlled access

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  name+","+description;
    }
    
    public static Category fromString(String categoryData) {
        String[] parts = categoryData.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid category data format. Expected 'name, description'.");
        }

        String name = parts[0].trim();
        String description = parts[1].trim();

        if (name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Category name and description cannot be empty.");
        }
        return new Category(name, description);
    }
}
