package org.example;

import java.util.Map;

public class Receipt {

    /**
     * Prints out a receipt for every successful order
     * @param order the order to be printed out in the receipt
     */
    public static void printReceipt(Order order) {
        // inform user and exit if there are no items in order
        if (order.getOrderedItems().isEmpty()) {
            System.out.println("\nNo items in the order. Receipt not generated. ");
            return;
        }

        System.out.println();
        System.out.println("--- RECEIPT ---");

        // looping through each item in the order and its quantity
        for (Map.Entry<FoodItem, Integer> entry : order.getOrderedItems().entrySet()) { // Map.Entry helps to get one (K, V) pair
            FoodItem item = entry.getKey(); // food item
            int quantity = entry.getValue(); // quantity of food item
            double total = item.getPrice() * quantity; // total price of food item

            // printing receipt
            System.out.printf("%s x%d - $%.2f\n", item.getName(), quantity, total);
        }

        //printing receipt
        double finalTotal = order.calculateTotal();
        System.out.printf("Total: $%.2f\n", finalTotal);
        System.out.println("---------------\n");
    }
}
