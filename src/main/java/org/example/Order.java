package org.example;

import java.util.*;

public class Order {
    private Map<FoodItem, Integer> orderedItemCounts;

    public Order() {
        orderedItemCounts = new LinkedHashMap<>();
    }

    public void addItem(FoodItem item) {
        orderedItemCounts.put(item, orderedItemCounts.getOrDefault(item, 0) + 1);
    }

    public double calculateTotal() {
        return orderedItemCounts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<FoodItem, Integer> getOrderedItems() {
        return orderedItemCounts;
    }
}
