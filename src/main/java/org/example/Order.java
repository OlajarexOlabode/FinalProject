package org.example;

import java.util.*;

public class Order {
    private Map<FoodItem, Integer> orderedItemCounts;

    public Order() {
        orderedItemCounts = new LinkedHashMap<>();
    }

    /**
     * Adding an item to the order or increase its quantity
     * @param item
     */
    public void addItem(FoodItem item) {
        orderedItemCounts.put(item, orderedItemCounts.getOrDefault(item, 0) + 1);
    }

    /**
     * Calculating the total price of the order
     * @return the total price
     */
    public double calculateTotal() {
        return orderedItemCounts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<FoodItem, Integer> getOrderedItems() {
        return orderedItemCounts;
    }
}
