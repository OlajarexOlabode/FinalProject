package org.example;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User { // inherits username from the User class
    private List<Order> deliveryOrders;

    public Driver(String username) {
        super(username);
        this.deliveryOrders = new ArrayList<>();
    }

    /**
     * allows the driver to accept a delivery order
     * @param order the order to be accepted by the driver
     */
    public void acceptOrder(Order order) {
        // ensuring the order is not null. can not accept a null order
        if (order != null) {
            deliveryOrders.add(order);
            System.out.println(username + " has accepted the order!");
        }
    }

    /**
     * allows driver to view the orders to be delivered
     */
    public void viewDeliveryOrders() {
        // print out message if there are no orders to be delivered
        if (deliveryOrders.isEmpty()) {
            System.out.println("\nNo orders to be delivered by " + username + ".");
            return;
        }

        // print out orders to be delivered
        System.out.println("\nOrders to be delivered by: " + username);
        for (int i = 0; i < deliveryOrders.size(); i++) {
            System.out.println("Order #" + (i + 1));
            Receipt.printReceipt(deliveryOrders.get(i));
        }
    }

    @Override
    public void viewMenu(Menu menu) { // no use for this method in Driver class
        System.out.println("Unable to access the menu." );
    }

    public List<Order> getDeliveryOrders() {
        return deliveryOrders;
    }

    public void setDeliveryOrders(List<Order> deliveryOrders) {
        this.deliveryOrders = deliveryOrders;
    }
}
