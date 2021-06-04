package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item added: " + item);
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
                int id = Integer.valueOf(input.askInt("Enter ID: "));
                    Item tmp = new Item(input.askStr("Enter new name: "));
                    if (tracker.replace(id, tmp)) {
                        System.out.println("Item updated");
                    } else {
                        System.out.println("Error");
                    }
            } else if (select == 3) {
                System.out.println("=== Delete Items by ID ====");
                int id = Integer.valueOf(input.askInt("Enter ID for delete: "));
                if (tracker.delete(id)) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("=== Find Items by ID ====");
                int id = Integer.valueOf(input.askInt("Enter ID: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(tracker.findById(id));
                } else {
                    System.out.println("Item not found!");
                }
            } else if (select == 5) {
                System.out.println("=== Find Items by name ====");
                String name = input.askStr("Enter name: ");
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
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}