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

    }

    /**
     * Adding food item to menu
     * @param menu the menu to be changed
     * @param item the item to be added
     */
    public void addFoodItem(Menu menu, FoodItem item) {

    }

    /**
     * Removing food item from menu
     * @param menu the menu to be changed
     * @param itemName the item to be removed
     */
    public void removeFoodItem(Menu menu, String itemName) {

    }
}
