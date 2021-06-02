package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int exp;

    public Surgeon(int exp) {
        this.exp = exp;
    }

    public Surgeon(String name, String surname, String education, String birthday, int exp) {
        super(name, surname, education, birthday);
        this.exp = exp;
    }

    public void makeOperation(Pacient pacient) {
    }
}