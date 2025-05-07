package org.example;

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
        System.out.println("Admin - Menu: ");
        menu.getItems()
                .forEach(item -> System.out.printf("- %s: $%.2f", item.getName(), item.getPrice()));
    }

    /**
     * Adding food item to menu
     * @param menu the menu to be changed
     * @param item the item to be added
     */
    public void addFoodItem(Menu menu, FoodItem item) {
        if (item != null && menu != null) {
            menu.addItem(item);
            System.out.println(item.getName() + " added.");
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
        if (itemName != null && itemName.isBlank()) { //isBlank for empty/whitespaces
            menu.removeItem(itemName);
            System.out.println(itemName + " removed.");
        } else {
            System.out.println("Invalid item name.");
        }
    }
}
