package org.example;

public class Customer extends User implements Orderable {
    private Order order;

    public Customer(String username, Order order) {
        super(username);
        this.order = order;
    }

    @Override
    public void viewMenu(Menu menu) {

    }

    @Override
    public void placeOrder(Menu menu) {

    }
}
