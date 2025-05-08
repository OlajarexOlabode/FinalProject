package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void testAddItem() {
        Order order = new Order();
        FoodItem burger = new FoodItem("Burger", 4.00);

        order.addItem(burger);

        boolean containsBurger = order.getOrderedItems().containsKey(burger);
        int quantity = order.getOrderedItems().get(burger);

        assertTrue(containsBurger, "Burger added in order" );
        Assertions.assertEquals(1, quantity, "Burger x1");
    }

    @Test
    public void testAddMultipleOfSameItem() {
        Order order = new Order();
        FoodItem fries = new FoodItem("Fries", 2.00);

        order.addItem(fries);
        order.addItem(fries);

        int quantity = order.getOrderedItems().get(fries);
        Assertions.assertEquals(2, quantity, "Fries x2");
    }

    @Test
    public void testCalculateTotal() {
        Order order = new Order();
        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.00);

        order.addItem(burger);
        order.addItem(fries);
        order.addItem(fries);

        double total = order.calculateTotal();
        Assertions.assertEquals(6.00, total, 0.01, "Accurate total");
    }
}
