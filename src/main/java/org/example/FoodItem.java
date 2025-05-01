package org.example;

import java.util.Objects;

public class FoodItem {
    private String name;
    private double price;
    private String category;

    public FoodItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return Double.compare(price, foodItem.price) == 0 && Objects.equals(name, foodItem.name) && Objects.equals(category, foodItem.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category);
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
