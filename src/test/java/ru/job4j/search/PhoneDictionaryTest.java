package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanovich", "124872", "Rostov")
        );
        var persons = phones.find("487");
        assertThat(persons.size(), is(2));
    }

    @Test
    public void whenFindBySurName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanovich", "124872", "Rostov")
        );
        var persons = phones.find("nov");
        assertThat(persons.size(), is(1));
    }

    @Test
    public void whenFindBySurNameAndAdress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentevsto", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Ivanovich", "124872", "Rostov")
        );
        var persons = phones.find("sto");
        assertThat(persons.size(), is(2));
    }

    @Test
    public void whenFindEmptyNumber() {
        var phones = new PhoneDictionary();
        var persons = phones.find("487");
        assertThat(persons.size(), is(0));
    }
}