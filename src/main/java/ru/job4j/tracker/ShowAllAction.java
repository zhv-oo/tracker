package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item tmp : items) {
                System.out.println(tmp);
            }
        } else {
            System.out.println("Items not found!");
        }
        return true;
    }
}
