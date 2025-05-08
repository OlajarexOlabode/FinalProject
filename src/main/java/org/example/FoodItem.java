package org.example;

import java.util.Comparator;
import java.util.Objects;

public class FoodItem implements Comparable<FoodItem> {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(FoodItem other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return Double.compare(price, foodItem.price) == 0 && Objects.equals(name, foodItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
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
}

class PriceComparator implements Comparator<FoodItem> {
    @Override
    public int compare(FoodItem o1, FoodItem o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}