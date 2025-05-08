package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {
    private static final String MENU_FILE_PATH = "src/main/resources/menu.csv";

    /**
     * reading menu from a file
     * @return list of food items
     */
    public static List<FoodItem> loadMenu() {
        List<FoodItem> items = new ArrayList<>();
        File file = new File(MENU_FILE_PATH);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    items.add(new FoodItem(name, price));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return items;
    }

    /**
     * Saves menu items to a csv file
     * @param items the food items to save
     */
    public static void saveMenu(Collection<FoodItem> items) {
        File file = new File(MENU_FILE_PATH);

        try (FileWriter fw = new FileWriter(file)){
            for (FoodItem item : items) {
                fw.write(item.getName() + "," + item.getPrice() + "\n");
            }
        } catch (IOException e) {
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
            for (Map.Entry<FoodItem, Integer> entry : order.getOrderedItems().entrySet()) {
                FoodItem item = entry.getKey();
                int quantity = entry.getValue();
                double price = item.getPrice();

                System.out.printf("%s,%d,%.2f\n", item.getName(), quantity, price);
            }

        } catch (IOException e) {
            System.out.println("Failed to save order.");
        }

    }
}
