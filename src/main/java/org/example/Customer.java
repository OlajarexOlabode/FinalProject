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
        System.out.println("Customer - Menu:");
        menu.getItems()
                .forEach(item ->
                        System.out.printf("- %s: $%.2f ", item.getName(), item.getPrice()));
    }

    /**
     * Allows customer to place order
     * @param menu from where the order is placed
     */
    @Override
    public void placeOrder(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;

        while (ordering) {
            System.out.println(" Menu:");
            viewMenu(menu);

            System.out.print("What do you wish to order? Enter 'done' to finish: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                ordering = false;
            } else {
                FoodItem choice = menu.findItemByName(input);
                if (choice != null) {
                    order.addItem(choice);
                    System.out.println(choice.getName() + "is added to your order.");
                } else {
                    System.out.println("Item not found. Please try again.");
                }
            }
        }

        double total = order.calculateTotal();
        System.out.printf(" Your order is complete. Total: $%.2f ", total);

        Receipt.printReceipt(order);
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
