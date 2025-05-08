package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.getItems().addAll(FileManager.loadMenu());
        List<Order> availableOrders = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to Big Bactivities!");
            System.out.println("1. Customer\n2. Admin\n3. Driver\n4. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    Order order = new Order();
                    Customer customer = new Customer("User", order);
                    customer.viewMenu(menu);
                    customer.placeOrder(menu);

                    if (!order.getOrderedItems().isEmpty()) {
                        availableOrders.add(order);  // add to available orders for the driver
                    }
                    FileManager.saveOrder(order);
                }
                case "2" -> {
                    Admin admin = new Admin("Admin" );
                    boolean adminRunning = true;
                    admin.viewMenu(menu);

                    while (adminRunning) {
                        System.out.println("\n1. Add item\n2. Remove item\n3. Exit\nChoose an action: " );
                        String action = scanner.nextLine();
                        if (action.equals("1")) {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter price: ");
                            double price = Double.parseDouble(scanner.nextLine());
                            admin.addFoodItem(menu, new FoodItem(name, price));
                        } else if (action.equals("2")) {
                            if(menu.getItems().isEmpty()) {
                                System.out.println("Menu is empty. There is nothing to remove.");
                            } else {
                                System.out.print("Enter name to remove: " );
                                String name = scanner.nextLine();
                                admin.removeFoodItem(menu, name);
                            }
                        } else if (action.equals("3")) {
                            System.out.println("Exiting admin section..."); break;
                        } else {
                            System.out.println("Invalid action!");
                        }

                        System.out.print("Enter 'yes' to perform another action or 'no' to exit: " );
                        String answer = scanner.nextLine().toLowerCase();
                        if (!answer.equals("yes" )) {
                            adminRunning = false; // only exits the admin loop
                        }
                    }
                    FileManager.saveMenu(menu.getItems());
                }
                case "3" -> {
                    System.out.print("Enter driver username: ");
                    String name = scanner.nextLine();
                    Driver driver = new Driver(name);

                    if (availableOrders.isEmpty()) {
                        System.out.println("\nNo available orders to accept.");
                        break;
                    }

                    System.out.println("\nAvailable Orders:");
                    for (int i = 0; i < availableOrders.size(); i++) {
                        System.out.println("Order #" + (i + 1));
                        Receipt.printReceipt(availableOrders.get(i));
                    }

                    System.out.print("Enter order number to accept or '0' to cancel: ");
                    String input = scanner.nextLine();

                    try {
                        int selection = Integer.parseInt(input);
                        if (selection == 0) {
                            System.out.println("No order accepted.");
                        } else if (selection >= 1 && selection <= availableOrders.size()) {
                            Order selectedOrder = availableOrders.remove(selection - 1);
                            driver.acceptOrder(selectedOrder);
                        } else {
                            System.out.println("Invalid order number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }

                    //showing accepted orders
                    driver.viewDeliveryOrders();
                }
                case "4" -> {
                    System.out.println("See you soon!");
                    running = false;
                }
                default -> System.out.println("Invalid input. Try again.");
            }
        }

        scanner.close();
    }
}
