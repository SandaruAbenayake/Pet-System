/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thepawsshop.thepawsshop.services;

import com.thepawsshop.thepawsshop.models.Category;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CategoryService {
    final String filePath = "src/main/java/com/thepawsshop/thepawsshop/util/data/category.txt";
    
     public List<Category> loadCategories() {
        List<Category> categories = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    categories.add(Category.fromString(line));
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing category data: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for (Category category : categories) {
            System.out.println(category.getName());
        }
        return categories;
    }


    public boolean saveCategory(Category category) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(category.toString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error saving category: " + e.getMessage());
            return false;
        }
    }
    
}
