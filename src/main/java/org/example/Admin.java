package org.example;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String username) {
        super(username);
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

            switch (choice) {
                case "1" -> {
                    if (menu.getItems().isEmpty()) {
                        System.out.println("The menu is empty.");
                    } else {
                        menu.sortByName();
                    }
                }
                case "2" -> {
                    if (menu.getItems().isEmpty()) {
                        System.out.println("The menu is empty.");
                    } else {
                        menu.sortByPrice();
                    }
                }
                case "3" -> System.out.println("Here's what's available:" );
                default -> {
                    System.out.println("Invalid option. Choose 1,2, or 3." );
                    continue;
                }
            }

            break;
        }
            menu.getItems()
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
            FoodItem toRemove = menu.findItemByName(itemName);
            if (toRemove != null) {
                menu.removeItem(itemName);
                System.out.println(itemName + " removed.");
            } else {
                System.out.println(itemName + " is not in the menu.");
            }
        } else {
            System.out.println("Invalid item name.");
        }
    }
}
