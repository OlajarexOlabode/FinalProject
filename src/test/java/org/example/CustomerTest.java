package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    /**
     * customer adds two items to order
     */
    @Test
    void testAddItemToOrder() {
        Order order = new Order();
        Menu menu = new Menu();

        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.50);

        menu.addItem(burger);
        menu.addItem(fries);

        order.addItem(burger);
        order.addItem(burger);

        assertEquals(2, order.getOrderedItems().get(burger));
        assertEquals(8.00, order.calculateTotal(), 0.01);
    }

    /**
     * customer removes item from order
     */
    @Test
    public void testRemoveItemFromOrder() {
        Order order = new Order();
        Menu menu = new Menu();

        FoodItem burger = new FoodItem("Burger", 4.00);
        FoodItem fries = new FoodItem("Fries", 2.50);

        menu.addItem(burger);
        menu.addItem(fries);

        order.addItem(fries);
        order.removeItem(fries);  // remove completely

        assertFalse(order.getOrderedItems().containsKey(fries));
    }
}
