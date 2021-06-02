package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int rsl = 0;
        for (Product tmp : products) {
            if (tmp == null) {
                break;
            } else {
                rsl++;
            }
        }
        return rsl == products.length ? -1 : rsl;
    }
}