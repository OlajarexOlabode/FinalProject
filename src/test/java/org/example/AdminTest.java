package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    /**
     * adding food item to menu
     */
    @Test
    public void testAddFoodItem1() {
        Admin admin = new Admin("Admin");
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);

        admin.addFoodItem(menu, burger);

        boolean contains = menu.getItems().contains(burger);
        Assertions.assertTrue(contains, "Admin added burger to the menu");
    }

    /**
     * adding null food item to menu
     */
    @Test
    public void testAddFoodItem2() {
        Admin admin = new Admin("Admin");
        Menu menu = new Menu();

        admin.addFoodItem(menu, null);

        Assertions.assertEquals(0, menu.getItems().size(), "Null item not added to menu.");
    }

    /**
     * removing item in the menu
     */
    @Test
    public void testRemoveFoodItem1() {
        Admin admin = new Admin("Admin");
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        menu.addItem(burger);

        admin.removeFoodItem(menu, "Burger");

        boolean contains = menu.getItems().stream() // anyMatch
                .anyMatch(item -> item.getName().equalsIgnoreCase("Burger"));

        Assertions.assertFalse(contains, "Admin removed burger from menu.");
    }

    /**
     * removing item that is not in the menu
     */
    @Test
    public void testRemoveFoodItem2() {
        Admin admin = new Admin("Admin");
        Menu menu = new Menu();
        FoodItem burger = new FoodItem("Burger", 4.00);
        menu.addItem(burger);

        admin.removeFoodItem(menu, "Wrap");

        Assertions.assertEquals(1, menu.getItems().size(), "Menu size is the same.");
        Assertions.assertTrue(menu.getItems().contains(burger), "Burger is in menu.");
    }
}
