package org.example;

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

    }

    /**
     * Allows customer to place order
     * @param menu from where the order is placed
     */
    @Override
    public void placeOrder(Menu menu) {

    }
}
