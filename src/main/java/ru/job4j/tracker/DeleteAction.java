package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Items by ID ====");
        int id = input.askInt("Enter ID for delete: ");
        if (tracker.delete(id)) {
            out.println("Item deleted");
        } else {
            out.println("Error");
        }
        return true;
    }
}
