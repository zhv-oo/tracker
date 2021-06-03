package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        System.out.println("Run");
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                if (items.length != 0) {
                    for (Item tmp : items) {
                        System.out.println(tmp);
                    }
                } else {
                    System.out.println("Items not found!");
                }
            } else if (select == 2) {
                System.out.println("=== Edit Items by ID ====");
                System.out.print("Enter ID: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.findById(id) != null) {
                    System.out.print("Enter new name: ");
                    Item tmp = new Item(scanner.nextLine());
                    if (tracker.replace(id, tmp)) {
                        System.out.println("Item updated");
                    } else {
                        System.out.println("Error");
                    }
                } else {
                    System.out.println("Item not found!");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Items by ID ====");
                System.out.print("Enter ID for delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("=== Find Items by ID ====");
                System.out.print("Enter ID: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(tracker.findById(id));
                } else {
                    System.out.println("Item not found!");
                }
            } else if (select == 5) {
                System.out.println("=== Find Items by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item tmp : items) {
                        System.out.println(tmp);
                    }
                } else {
                    System.out.println("Items not found!");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}