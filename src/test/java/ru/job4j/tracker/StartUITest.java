package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    /*
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddItemTwo() {
        String[] answers = {"Fix PC", "New Item"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[1];
        Item expected = new Item("New Item");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenEditItemWhenTwo() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("new item");
        Item itemTwo = new Item("new item");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        String[] answers = {
                String.valueOf(itemTwo.getId()),
                "edited item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(itemTwo.getId());
        assertThat(replaced.getName(), is("edited item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("new item");
        Item itemTwo = new Item("new item");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        String[] answers = {
                String.valueOf(itemOne.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        boolean result = tracker.delete(itemOne.getId());
        assertFalse(result);
        assertNull(tracker.findById(itemOne.getId()));
    }

    @Test
    public void whenDeleteTwoItems() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("new item");
        Item itemTwo = new Item("new item");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        String[] answers = {
                String.valueOf(itemOne.getId()), String.valueOf(itemTwo.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        tracker.delete(itemOne.getId());
        tracker.delete(itemTwo.getId());
        assertEquals(0, tracker.findAll().length);
        assertNull(tracker.findById(itemOne.getId()));
        assertNull(tracker.findById(itemTwo.getId()));
    }
     */
}