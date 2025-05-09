package org.example;

import java.util.Scanner;

public class Customer extends User implements Orderable {
    private Order order;

    public Customer(String username, Order order) {
        super(username);
        this.order = order;
    }

    /**
     * Allows customer to view menu
     * @param menu the menu to be viewed
     */
    @Override
    public void viewMenu(Menu menu) {
        System.out.println("\nCustomer - Menu:");
        menu.getItems()
                .forEach(item ->
                        System.out.println(String.format("- %s: $%.2f ", item.getName(), item.getPrice())));
    }

    /**
     * Allows customer to place order
     * @param menu from where the order is placed
     */
    @Override
    public void placeOrder(Menu menu) {
        // if menu is empty, cancel order
        if (menu.getItems().isEmpty()) {
            System.out.println("\nThe menu is empty. Try again later.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;

        System.out.println(); // skip a line

        // runs as long as customer is not done ordering
        while (ordering) {
            System.out.print("Do you wish to add or remove an item? (add/remove/done): ");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "add" -> {
                    System.out.print("Enter item name to add: ");
                    String itemName = scanner.nextLine();
                    // finding item name in menu
                    FoodItem item = menu.findItemByName(itemName);

                    if (item != null) {
                        System.out.print("How many would you like? ");
                        try {
                            int qty = Integer.parseInt(scanner.nextLine());
                            if (qty > 0) {
                                // adding the item to the order with the accurate quantity
                                for (int i = 0; i < qty; i++) {
                                    order.addItem(item);
                                }
                                System.out.println(qty + "x " + item.getName() + " added to your order.");
                            } else {
                                System.out.println("Quantity must be at least 1.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number.");
                        }
                    } else {
                        System.out.println("Item is not in the menu.");
                    }
                }

                case "remove" -> {
                    System.out.print("Enter item to remove: ");
                    String itemName = scanner.nextLine().trim();
                    // finding item name in order before removing it
                    FoodItem item = menu.findItemByName(itemName);

                    if (item != null && order.getOrderedItems().containsKey(item)) {
                        order.removeItem(item);
                        System.out.println(item.getName() + " removed from your order.");
                    } else {
                        System.out.println("Item is not in your order.");
                    }
                }

                case "done" -> ordering = false; // exiting the loop. customer is done

                default -> System.out.println("Invalid option. Enter add, remove, or done.");
            }
        }

        //calculating and printing the total
        double total = order.calculateTotal();
        System.out.println("\nOrder complete!");
        System.out.printf("Total: $%.2f ", total);
        System.out.println("\nThanks for ordering! Come again soon.");

        // printing receipt
        Receipt.printReceipt(order);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
