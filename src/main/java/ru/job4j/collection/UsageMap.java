package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("zhitenevoo@yandex.ru", "Oleg Zhv");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + " " + "value: " + entry.getValue());
        }
    }
}