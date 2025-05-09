package org.example;

import java.util.*;

public class Order {
    private Map<FoodItem, Integer> orderedItemCounts;

    public Order() {
        orderedItemCounts = new LinkedHashMap<>(); // following order of insertion
    }

    /**
     * Adding an item to the order or increase its quantity
     * @param item the item to be added in the order
     */
    public void addItem(FoodItem item) {
        orderedItemCounts.put(item, orderedItemCounts.getOrDefault(item, 0) + 1);
        // if item is already in map, it gets the current count, if not it returns 0 by default
        // +1. adding one more of the item
    }

    /**
     * removing item from order
     * @param item the item to be removed
     */
    public void removeItem(FoodItem item) {
        if (orderedItemCounts.containsKey(item)) {
            int count = orderedItemCounts.get(item);
            if (count > 1) {
                orderedItemCounts.put(item, count - 1);
            } else {
                orderedItemCounts.remove(item);
            }
        }
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

    public void setOrderedItemCounts(Map<FoodItem, Integer> orderedItemCounts) {
        this.orderedItemCounts = orderedItemCounts;
    }
}
