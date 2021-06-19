package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        Map<Character, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            Character key = left.charAt(i);
            if (!leftMap.containsKey(key)) {
                leftMap.put(key, 1);
            } else {
                leftMap.put(key, leftMap.get(key) + 1);
            }
        }
        for (int i = 0; i < right.length(); i++) {
            Character key = right.charAt(i);
            Integer value = leftMap.get(key);
            if (!leftMap.containsKey(key)) {
                rsl = false;
                break;
            } else if (value == 1) {
                leftMap.remove(key);
            } else {
                leftMap.put(key, value - 1);
            }
        }
        return leftMap.isEmpty() && rsl;
    }
}
