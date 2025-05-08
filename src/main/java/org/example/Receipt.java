package org.example;

import java.util.Map;

public class Receipt {

    /**
     * Prints out a receipt for every successful order
     * @param order the order to be printed out in the receipt
     */
    public static void printReceipt(Order order) {
        if (order.getOrderedItems().isEmpty()) {
            System.out.println("\nNo items in the order. Receipt not generated. ");
            return;
        }

        System.out.println();
        System.out.println("--- RECEIPT ---");

        for (Map.Entry<FoodItem, Integer> entry : order.getOrderedItems().entrySet()) { // Map.Entry helps to get one (K, V) pair
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            double total = item.getPrice() * quantity;

            System.out.printf("%s x%d - $%.2f\n", item.getName(), quantity, total);
        }

        double finalTotal = order.calculateTotal();
        System.out.printf("Total: $%.2f\n", finalTotal);
        System.out.println("---------------\n");
    }
}
