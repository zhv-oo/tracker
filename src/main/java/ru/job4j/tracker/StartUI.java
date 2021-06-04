package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
               StartUI.showAll(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
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

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item added: " + item);
    }

    public static void showAll(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item tmp : items) {
                System.out.println(tmp);
            }
        } else {
            System.out.println("Items not found!");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Items by ID ====");
        int id = input.askInt("Enter ID: ");
        Item tmp = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id, tmp)) {
            System.out.println("Item updated");
        } else {
            System.out.println("Error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Items by ID ====");
        int id = input.askInt("Enter ID for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Error");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find Items by ID ====");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(tracker.findById(id));
        } else {
            System.out.println("Item not found!");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
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
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}