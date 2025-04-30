package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> orderedItems;

    public Order() {
        orderedItems = new ArrayList<>();
    }

    public void addItem(FoodItem item) {

    }

    public double calculateTotal() {

        return 0;
    }

    public List<FoodItem> getOrderedItems() {

        return orderedItems;
    }

    public void setOrderedItems(List<FoodItem> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
