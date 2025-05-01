package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    public void testAddItem() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        menu.addItem(burger);

        boolean containsBurger = menu.getItems().contains(burger);
        Assertions.assertEquals(true, containsBurger, "Added burger");
    }

    @Test
    public void testRemoveItem() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.00);

        menu.addItem(burger);
        menu.addItem(fries);
        menu.removeItem("Fries");

        boolean containsFries = menu.getItems().stream()
                .anyMatch(item -> item.getName().equalsIgnoreCase("Fries"));

        Assertions.assertEquals(false, containsFries, "Removed fries");
    }

    @Test
    public void testFindItemByName() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        menu.addItem(burger);

        FoodItem found = menu.findItemByName("burger");

        Assertions.assertEquals(burger.getPrice(), found.getPrice(), 0.01);
        Assertions.assertEquals(burger.getName(), found.getName());
    }
}