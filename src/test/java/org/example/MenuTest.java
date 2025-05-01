package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    /**
     * test addItem method
     */
    @Test
    public void testAddItem() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        menu.addItem(burger);

        boolean containsBurger = menu.getItems().contains(burger);
        assertTrue(containsBurger, "Added burger"); // instead of assertEquals(true,..,..)
    }

    /**
     * test removeItem method
     */
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
        // anyMatch returns true if at least one element matches the condition, false if none

        assertFalse(containsFries, "Removed fries"); // instead of assertEquals(false,..,..)
    }

    /**
     * test findItemByName method
     */
    @Test
    public void testFindItemByName() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        menu.addItem(burger);

        FoodItem found = menu.findItemByName("burger");

        Assertions.assertEquals(burger.getName(), found.getName());
        Assertions.assertEquals(burger.getPrice(), found.getPrice(), 0.01); // delta as price is double
    }
}