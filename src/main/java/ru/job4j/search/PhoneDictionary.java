package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> preName = (k) -> k.getName().contains(key);
        Predicate<Person> preSurname = (k) -> k.getSurname().contains(key);
        Predicate<Person> prePhone = (k) -> k.getPhone().contains(key);
        Predicate<Person> preAdress = (k) -> k.getAddress().contains(key);
        Predicate<Person> combine = preName.or(preSurname).or(prePhone).or(preAdress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}