package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit Items by ID ====");
        int id = input.askInt("Enter ID: ");
        Item tmp = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id, tmp)) {
            System.out.println("Item updated");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
