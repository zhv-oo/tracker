package ru.job4j.oop;

public class Programmer extends Engineer {

    private String lang;

    public Programmer(String lang) {
        this.lang = lang;
    }

    public Programmer(String name, String surname, String education, String birthday, String lang) {
        super(name, surname, education, birthday);
        this.lang = lang;
    }

    public void makeProgram(Soft soft) {
    }
}