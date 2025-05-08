package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    /**
     * ordering item that is on the menu
     */
    @Test
    public void testAddItem1() {
        Order order = new Order();
        FoodItem burger = new FoodItem("Burger", 4.00);

        order.addItem(burger);

        boolean containsBurger = order.getOrderedItems().containsKey(burger);
        int quantity = order.getOrderedItems().get(burger);

        assertTrue(containsBurger, "Burger added in order" );
        Assertions.assertEquals(1, quantity, "Burger x1");
    }

    /**
     * ordering item that is not on the menu
     */
    @Test
    public void testAddItem2() {
        Menu menu = new Menu();
        Order order = new Order();

        menu.addItem(new FoodItem("Burger", 4.00));

        FoodItem notFound = menu.findItemByName("Croissant");

        Assertions.assertNull(notFound, "Croissant is not on the menu");

        Assertions.assertEquals(0, order.getOrderedItems().size(), "Order is empty.");
    }

    /**
     * ordering multiple of same item
     */
    @Test
    public void testAddItem3() {
        Order order = new Order();
        FoodItem fries = new FoodItem("Fries", 2.00);

        order.addItem(fries);
        order.addItem(fries);

        boolean containsFries = order.getOrderedItems().containsKey(fries);
        int quantity = order.getOrderedItems().get(fries);

        assertTrue(containsFries, "Fries is in the order");
        Assertions.assertEquals(2, quantity, "Fries x2");
    }

    /**
     * calculating total of items in order
     */
    @Test
    public void testCalculateTotal1() {
        Order order = new Order();
        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.00);

        order.addItem(burger);
        order.addItem(fries);
        order.addItem(fries);

        double total = order.calculateTotal();
        Assertions.assertEquals(6.00, total, 0.01, "Accurate total of $6.00");
    }

    /**
     * calculating total of empty order
     */
    @Test
    public void testCalculateTotal2() {
        Order order = new Order();

        double total = order.calculateTotal();

        Assertions.assertEquals(0.00, total, 0.01, "Total is $0.00. Order is empty.");
    }
}
