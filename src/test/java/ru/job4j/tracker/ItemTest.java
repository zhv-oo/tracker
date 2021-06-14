package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortLessToMoreTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("One"));
        items.add(new Item("Two"));
        items.add(new Item("Three"));
        items.sort(new SortByNameItem());
        assertThat(items.get(2).getName(), is("Two"));
    }

    @Test
    public void sortMoreToLessTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("One"));
        items.add(new Item("Two"));
        items.add(new Item("Three"));
        items.sort(new SortReversByNameItem());
        assertThat(items.get(0).getName(), is("Two"));
    }
}