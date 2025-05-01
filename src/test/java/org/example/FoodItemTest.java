package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodItemTest {
    @Test
    public void testGetters() {
        FoodItem item = new FoodItem("Burger", 4.00);

        Assertions.assertEquals("Burger", item.getName());
        Assertions.assertEquals(4.00, item.getPrice(), 0.01); // delta is needed as value is "double"
    }

    @Test
    public void testEquals() {
        FoodItem item1 = new FoodItem("Fries", 2.00);
        FoodItem item2 = new FoodItem("Fries", 2.00);

        Assertions.assertEquals(item1, item2, "Same item names");
    }
}