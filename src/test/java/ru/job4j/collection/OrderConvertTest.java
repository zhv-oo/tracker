package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenTwoOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("5ffd", "Boots"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("5ffd"), is(new Order("5ffd", "Boots")));
    }

    @Test
    public void whenAnyOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("5ffd", "Boots"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(orders.size()));
    }

    @Test
    public void whenDoubleOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("5ffd", "Boots"));
        orders.add(new Order("5ffd", "Boots"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(2));
    }

    @Test
    public void whenAnyDoubleOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Dresses"));
        orders.add(new Order("5ffd", "Boots"));
        orders.add(new Order("5ffd", "Boots"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(2));
    }
}