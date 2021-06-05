package ru.job4j.ex;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenError() {
        Fact fact = new Fact();
        fact.calc(-1);
    }

    @Test
    public void withOutError() {
        Fact fact = new Fact();
        assertEquals(fact.calc(0), 1);
    }
}