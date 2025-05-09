package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {
    // path to csv file
    private static final String MENU_FILE_PATH = "src/main/resources/menu.csv";

    /**
     * reading menu from a csv file
     * @return list of food items read from the file
     */
    public static List<FoodItem> loadMenu() {
        List<FoodItem> items = new ArrayList<>();
        File file = new File(MENU_FILE_PATH);

        try (Scanner scanner = new Scanner(file)) {
            // reading each line from the file
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                // making sure the line has two parts
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    // creates and adds the food item to the list
                    items.add(new FoodItem(name, price));
                }
            }
        } catch (FileNotFoundException e) {
            // exception if file can't be found
            System.out.println("File not found.");
        }

        return items; // returning the list
    }

    /**
     * Saves menu items to a csv file
     * @param items the food items to save
     */
    public static void saveMenu(Collection<FoodItem> items) {
        File file = new File(MENU_FILE_PATH);

        try (FileWriter fw = new FileWriter(file)){
            // writing each food item as a line in the file
            for (FoodItem item : items) {
                fw.write(item.getName() + "," + item.getPrice() + "\n");
            }
        } catch (IOException e) {
            // exception for writing error
            throw new RuntimeException("Failed to save menu.", e);
        }
    }

    /**
     * Saves an order to a csv file
     * @param order the order to save
     */
    public static void saveOrder(Order order) {
        File file = new File(MENU_FILE_PATH);

        try (FileWriter fw = new FileWriter(file)) {
            System.out.println("Item,Quantity,Price:");
            // looping through the order and printing each entry in csv form
            for (Map.Entry<FoodItem, Integer> entry : order.getOrderedItems().entrySet()) {
                FoodItem item = entry.getKey();
                int quantity = entry.getValue();
                double price = item.getPrice();

                // printing order details to console
                System.out.printf("%s,%d,%.2f\n", item.getName(), quantity, price);
            }
        } catch (IOException e) {
            System.out.println("Failed to save order.");
        }
    }
}
