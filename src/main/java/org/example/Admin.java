package org.example;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String username) {
        super(username); // not is use
    }

    /**
     * Allows admin to view menu
     * @param menu the menu to be viewed
     */
    @Override
    public void viewMenu(Menu menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdmin - Menu:" );

        while (true) {
            System.out.println("1. Sort by Name  \n2. Sort by Price \n3. Update menu" );
            System.out.print("Choose an option: " );
            String choice = scanner.nextLine();

            // handling admins choices
            switch (choice) {
                case "1" -> {
                    // if menu is empty, alert the admin
                    if (menu.getItems().isEmpty()) {
                        System.out.println("The menu is empty!");
                    } else { // sort menu alphabetically by item name
                        menu.sortByName();
                    }
                }
                case "2" -> {
                    // if menu is empty, alert the admin
                    if (menu.getItems().isEmpty()) {
                        System.out.println("The menu is empty.");
                    } else { // sort menu by price in ascending order
                        menu.sortByPrice();
                    }
                }
                case "3" -> System.out.println("Here's what's available:" );
                default -> {
                    // if input is invalid, prompt this message
                    System.out.println("Invalid option. Choose 1,2, or 3." );
                    continue; // going back to the start of the loop
                }
            }
            break; // exiting loop after valid input
        }
            menu.getItems() // printing final menu
                    .forEach(item -> System.out.println(String.format("- %s: $%.2f", item.getName(), item.getPrice())));
    }

    /**
     * Adding food item to menu
     * @param menu the menu to be changed
     * @param item the item to be added
     */
    public void addFoodItem(Menu menu, FoodItem item) {
        if (item != null && menu != null) {
            menu.addItem(item);
        } else {
            // notify if input is valid
            System.out.println("No item/menu.");
        }
    }

    /**
     * Removing food item from menu
     * @param menu the menu to be changed
     * @param itemName the item to be removed
     */
    public void removeFoodItem(Menu menu, String itemName) {
        if (itemName != null) {
            // finding the item in menu
            FoodItem toRemove = menu.findItemByName(itemName);
            if (toRemove != null) {
                // if found, remove from menu
                menu.removeItem(itemName);
                System.out.println(itemName + " removed.");
            } else {
                // item not found in menu
                System.out.println(itemName + " is not in the menu.");
            }
        } else {
            //invalid item name
            System.out.println("Invalid item name.");
        }
    }
}
