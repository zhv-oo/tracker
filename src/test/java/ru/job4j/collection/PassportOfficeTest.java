package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addFalse() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizen));
    }

    @Test
    public void addTwo() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenTwo = new Citizen("3f43b", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizenTwo);
        assertThat(office.get(citizenTwo.getPassport()), is(citizenTwo));
    }
}