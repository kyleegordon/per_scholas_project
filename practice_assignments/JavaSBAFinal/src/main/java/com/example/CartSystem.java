package com.example;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class CartSystem extends TheSystem {
    CartSystem() {
        super();
    }

    @Override
    public void display() {
        System.out.println("Cart:");
        System.out.format("%-20s %-20s %-10s %-10s %-10s\n", "Name", "Description", "Price", "Quantity", "Sub Total");
        double subtotal = 0;
        final double SALES_TAX = 0.05;
        
        HashMap<String, Item> tempMap = super.getItemCollection();
        for (Map.Entry<String, Item> entry : tempMap.entrySet()){
            String key = entry.getKey();
            Item value = entry.getValue();
            double price = value.getItemPrice() * value.getQuantity();
            System.out.format("%-20s %-20s %-10.2f %-10d %-10.2f\n", value.getItemName(), value.getItemDesc(), value.getItemPrice(), value.getQuantity(), price);
            subtotal += (value.getItemPrice() * value.getQuantity());
        }
        
        double tax = subtotal * SALES_TAX;
        double total = subtotal + tax;
        System.out.format("%-20s %-20.2f\n", "Pre-tax Total", subtotal);
        System.out.format("%-20s %-20.2f\n", "Tax", tax);
        System.out.format("%-20s %-20.2f\n", "Total", total);
    }
}
