package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Edit Items by ID ====");
        int id = input.askInt("Enter ID: ");
        Item tmp = new Item(input.askStr("Enter new name: "));
        if (store.replace(id, tmp)) {
            out.println("Item updated");
        } else {
            out.println("Error");
        }
        return true;
    }
}
