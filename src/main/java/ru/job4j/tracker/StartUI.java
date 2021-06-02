package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item newItem = new Item();
        Tracker tracker = new Tracker();
        tracker.add(newItem);
        System.out.println(tracker.findById(newItem.getId()));
    }
}