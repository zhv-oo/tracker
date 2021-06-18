package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            leftMap.put(i, (int) left.charAt(i));
        }
        for (int i = 0; i < right.length(); i++) {
            rightMap.put(i, (int) right.charAt(i));
        }
        int lft = 0;
        for (Integer tmp : leftMap.values()) {
            lft += tmp;
        }
        int rgt = 0;
        for (Integer tmp : rightMap.values()) {
            rgt += tmp;
        }
        return lft == rgt;
    }
}
