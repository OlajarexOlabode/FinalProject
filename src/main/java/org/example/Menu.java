package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Menu {
    private List<FoodItem> items;
    private Set<String> categories;

    public Menu() {
        items = new ArrayList<>();
        categories = new HashSet<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
        categories.add(item.getCategory());
    }

    public void removeItem(String itemName) {
        items = items.stream()
                .filter(item -> !item.getName().equalsIgnoreCase(itemName))
                .toList();
    }

    public FoodItem foodItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void printCategories() {
        categories.forEach(System.out::println);
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

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
}
