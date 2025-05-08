package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    /**
     * driver accepting an order
     */
    @Test
    public void testAcceptOrder1() {
        Driver driver = new Driver("Olajare");
        Order order = new Order();
        FoodItem burger = new FoodItem("Burger", 4.00);
        order.addItem(burger);

        driver.acceptOrder(order);

        List<Order> toDeliver = driver.getDeliveryOrders();

        Assertions.assertEquals(1, toDeliver.size(), "Driver has 1 order to deliver.");
        Assertions.assertTrue(toDeliver.contains(order), "Order to deliver is the accepted order.");
    }

    /**
     * driver accepting a null order
     */
    @Test
    public void testAcceptOrder2() {
        Driver driver = new Driver("Olabode");

        driver.acceptOrder(null);

        Assertions.assertEquals(0, driver.getDeliveryOrders().size(), "No order to accept.");
    }

}