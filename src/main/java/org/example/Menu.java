package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Menu {
    private List<FoodItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    /**
     * Adding food item to menu
     * @param item the input item
     */
    public void addItem(FoodItem item) {
        items.add(item);
    }

    /**
     * Removing food item from menu
     * @param itemName
     */
    public void removeItem(String itemName) {
        items = items.stream()
                .filter(item -> !item.getName().equalsIgnoreCase(itemName))
                .toList();
    }

    /**
     * Finding a food item by its name
     * @param name the name to look for
     * @return the food item if it is found or null if not
     */
    public FoodItem findItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void sortByName() {
    }

    public void sortByPrice() {
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }
}
