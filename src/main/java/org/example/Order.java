package org.example;

import java.util.*;

public class Order {
    private Map<FoodItem, Integer> orderedItemCounts;
    private static int nextOrderId = 1;
    private int orderId = 0;

    public Order() {
        orderedItemCounts = new LinkedHashMap<>(); // following order of insertion
        this.orderId = nextOrderId++;
    }

    /**
     * Adding an item to the order or increase its quantity
     * @param item the item to be added in the order
     */
    public void addItem(FoodItem item) {
        orderedItemCounts.put(item, orderedItemCounts.getOrDefault(item, 0) + 1);
        // if item is already in map, it gets the current count, if not it returns 0 by default
        // + 1 adding one more of the item
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

    public void assignOrderId() {
        if (orderId == 0 && !orderedItemCounts.isEmpty()) {
            this.orderId = nextOrderId++;
        }
    }

    public Map<FoodItem, Integer> getOrderedItems() {
        return orderedItemCounts;
    }

    public void setOrderedItemCounts(Map<FoodItem, Integer> orderedItemCounts) {
        this.orderedItemCounts = orderedItemCounts;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
