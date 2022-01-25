package com.example;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class AppSystem extends TheSystem {
    AppSystem() {
        super();
    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory:");
        System.out.format("%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Available Quantity");
        
        for (Map.Entry<String, Item> entry : super.getItemCollection().entrySet()) {
            Item value = entry.getValue();
            System.out.format("%-20s %-20s %-10.2f %-10d\n", value.getItemName(), value.getItemDesc(), value.getItemPrice(), value.getAvailableQuantity());  
        }
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        if (item == null){
            return false;
        } else if (super.getItemCollection().containsValue(item)){
            System.out.println(item.getItemName() + " is already in the App System");
            item.setQuantity(item.getQuantity() + 1);
            super.getItemCollection().put(item.getItemName(), item);
            return false;
        }
        
        item.setQuantity(1);
        super.getItemCollection().put(item.getItemName(), item);
        return true;
    }

    public Item reduceAvailableQuantity(String item_name) {
        if (super.getItemCollection().containsKey(item_name)){
            Item tempItem = super.getItemCollection().get(item_name);
            tempItem.setAvailableQuantity(tempItem.getAvailableQuantity() - 1);
            
            if (tempItem.getAvailableQuantity() < 1){
                super.getItemCollection().remove(item_name);
               
            }
            
            return tempItem;
        }
        return null;
    }
}
