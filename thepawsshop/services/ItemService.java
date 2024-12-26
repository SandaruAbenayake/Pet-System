/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thepawsshop.thepawsshop.services;

import com.thepawsshop.thepawsshop.models.Item;
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
public class ItemService {
    final String filePath = "src/main/java/com/thepawsshop/thepawsshop/util/data/items.txt";
    
    public List<Item> loadItem(){
        List<Item> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    items.add(Item.fromString(line));
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing item data: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for(Item item : items){
            System.out.println(item.getName());
        }
        return items;
    }
    
    public boolean saveItem(Item item) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write(item.toString()); 
        writer.newLine();
        return true; 
    } catch (IOException e) {
        System.err.println("Error saving item: " + e.getMessage());
        return false;
    }
}

    
}


