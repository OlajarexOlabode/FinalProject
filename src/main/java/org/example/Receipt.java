package org.example;

public class Receipt {
    public static void printReceipt(Order order) {
        System.out.println("----- Receipt -----");
        order.getOrderedItems().forEach((item, qty) -> {
            System.out.printf("%s x%d - $%.2f\n", item.getName(), qty, item.getPrice() * qty);
        });
        System.out.println("-------------------");
        System.out.printf("Total: $%.2f\n", order.calculateTotal());
    }
}
