package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    /**
     * adding a single item
     */
    @Test
    public void testAddItem1() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        menu.addItem(burger);

        boolean containsBurger = menu.getItems().contains(burger);
        assertTrue(containsBurger, "Added burger."); // instead of assertEquals(true,..,..)
    }

    /**
     * adding multiple items
     */
    @Test
    public void testAddItem2() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.00);

        menu.addItem(burger);
        menu.addItem(fries);

        boolean containsBoth = menu.getItems().contains(burger) && menu.getItems().contains(fries);
        assertTrue(containsBoth, "Burger and Fries added.");
    }

    /**
     * adding duplicate items
     */
    @Test
    public void testAddItem3() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        menu.addItem(burger);
        menu.addItem(burger);

        long burgerCount = menu.getItems().stream()
                .filter(item -> item.getName().equalsIgnoreCase("Burger"))
                .count();

        assertEquals(2, burgerCount, "Burger is added twice." );
    }

    /**
     * removing an item in menu
     */
    @Test
    public void testRemoveItem1() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.00);

        menu.addItem(burger);
        menu.addItem(fries);
        menu.removeItem("Fries");

        boolean containsFries = menu.getItems().stream()
                .anyMatch(item -> item.getName().equalsIgnoreCase("Fries"));
        // anyMatch returns true if at least one element matches the condition, false if none

        assertFalse(containsFries, "Removed fries."); // instead of assertEquals(false,..,..)
    }

    /**
     * removing an item not in the menu
     */
    @Test
    public void testRemoveItem2() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        menu.addItem(burger);
        menu.removeItem("Wings"); // pizza is not in the menu

        boolean containsBurger = menu.getItems().contains(burger);
        int menuSize = menu.getItems().size();

        assertTrue(containsBurger, "Burger is in menu.");
        assertEquals(1, menuSize, "One item in menu.");
    }

    /**
     * find item in menu by name
     */
    @Test
    public void testFindItemByName1() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        menu.addItem(burger);

        FoodItem found = menu.findItemByName("burger");

        Assertions.assertEquals(burger.getName(), found.getName());
        Assertions.assertEquals(burger.getPrice(), found.getPrice(), 0.01); // delta as price is double
    }

    /**
     * find item not in menu by name
     */
    @Test
    public void testFindItemByName2() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        menu.addItem(burger);

        FoodItem result = menu.findItemByName("Wings");

        Assertions.assertNull(result, "Null. Item not found.");
    }

    /**
     * sorting names in alphabetical order
     */
    @Test
    public void testSortByName() {
        Menu menu = new Menu();
        FoodItem fries = new FoodItem("Fries", 2.00);
        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem wings = new FoodItem("Wings", 3.00);

        menu.addItem(fries);
        menu.addItem(burger);
        menu.addItem(wings);

        menu.sortByName();

        List<FoodItem> sorted = menu.getItems();
        Assertions.assertEquals("Burger", sorted.get(0).getName());
        Assertions.assertEquals("Wings", sorted.get(1).getName());
        Assertions.assertEquals("Fries", sorted.get(2).getName());
    }

    /**
     * sorting prices in ascending order
     */
    @Test
    public void testSortByPrice() {
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.00);
        FoodItem wings = new FoodItem("Wings", 3.00);

        menu.addItem(burger);
        menu.addItem(fries);
        menu.addItem(wings);

        menu.sortByPrice();

        List<FoodItem> sorted = menu.getItems();
        Assertions.assertEquals("Fries", sorted.get(0).getName());
        Assertions.assertEquals("Wings", sorted.get(1).getName());
        Assertions.assertEquals("Burger", sorted.get(2).getName());
    }
}
