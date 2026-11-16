package part1_basic;

import java.util.ArrayList;

// Part 1. Basic Operations
public class ShoppingListManager {

    private ArrayList<String> items = new ArrayList<>();

    // Part 1.1 addItem
    public void addItem(String item) {
        items.add(item);
        System.out.println("Added: " + item);
    }

    // Part 1.2 removeItem
    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println("Removed: " + item);
        } else {
            System.out.println("Not found: " + item); // нету такого
        }
    }

    // Part 1.3 displayItems
    public void displayItems() {
        System.out.println("Shopping list:");
        if (items.isEmpty()) {
            System.out.println("  (empty)");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  " + i + ": " + items.get(i));
        }
    }

    // Part 1.4 Demo
    public static void main(String[] args) {
        ShoppingListManager list = new ShoppingListManager();

        list.displayItems(); // пустой

        list.addItem("Milk");
        list.addItem("Bread");
        list.addItem("Eggs");
        list.addItem("Apples");
        list.displayItems();

        list.removeItem("Bread");
        list.removeItem("Pizza"); // нет в списке
        list.displayItems();
    }
}
