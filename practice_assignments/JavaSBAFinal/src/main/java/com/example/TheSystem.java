package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.*;

public abstract class TheSystem {
   private HashMap<String, Item> itemCollection;

    TheSystem() {
        this.itemCollection = new HashMap<String, Item>();
        
        if (this.getClass().getSimpleName().equals("AppSystem")){
            //System.out.println("AppSystem Check");
            File file = new File("resources/sample.txt");
            //System.out.println("Absolute Path: " + file.getAbsolutePath());
            
            try {
                Scanner read = new Scanner(file);
                String line = "";
                while (read.hasNextLine()){
                    line = read.nextLine();
                    String[] data = line.split("\\s{2}");
                    Item newItem = new Item(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                    this.itemCollection.put(newItem.getItemName(), newItem);
                }
                read.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    public HashMap<String, Item> getItemCollection(){
        return itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
        if (item.getQuantity() >= item.getAvailableQuantity()){
            System.out.println("System is unable to add " + item.getItemName() 
                              + " to the card. System only has " + item.getAvailableQuantity()
                              + " " + item.getItemName() + "'s.'");
            return false;
        }
        return true;
    }
    
    public Boolean add(Item item) {
       if (item == null){
           return false;
       } else if (itemCollection.containsValue(item)){
           item.setQuantity(item.getQuantity() + 1);
           itemCollection.put(item.getItemName(), item);
           return true;
       } else if (!itemCollection.containsValue(item)){
           item.setQuantity(1);
           itemCollection.put(item.getItemName(), item);
           return true;
       }
        return false;
    }

    public Item remove(String itemName) {
        return itemCollection.remove(itemName);
    }

    public abstract void display();
}
