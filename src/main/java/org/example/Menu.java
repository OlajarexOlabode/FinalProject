package org.example;

import java.util.*;
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
        if (items.stream().anyMatch(existing -> existing.getName().equalsIgnoreCase(item.getName()))) {
            System.out.println(item.getName() +" is already in stock.");
        } else {
            items.add(item);
            System.out.println(item.getName() + " added.");
        }
    }

    /**
     * Removing food item from menu
     * @param itemName the input item name to remove
     */
    public void removeItem(String itemName) {
        items = items.stream()
                .filter(item -> !item.getName().equalsIgnoreCase(itemName))
                .collect(Collectors.toList());
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

    /**
     * sorts the food items by their names
     */
    public void sortByName() {
        items.sort((item1, item2) -> item1.getName().compareToIgnoreCase(item2.getName()));
        System.out.println("Menu sorted by name.");
    }

    /**
     * sorts the food items by their price
     */
    public void sortByPrice() {
        items.sort(new PriceComparator());
        System.out.println("Menu sorted by price.");
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }
}
