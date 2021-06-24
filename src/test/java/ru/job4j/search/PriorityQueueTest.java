package ru.job4j.search;

import org.junit.Test;
import java.util.LinkedList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityTwo() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("low5", 5));
        queue.put(new Task("low2", 2));
        queue.put(new Task("urgent3", 3));
        queue.put(new Task("middle", 3));
        var result = queue.take();
        assertThat(result.getDesc(), is("low2"));
    }
}