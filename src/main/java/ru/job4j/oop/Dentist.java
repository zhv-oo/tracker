package ru.job4j.oop;

public class Dentist extends Doctor {
    private boolean stud;

    public Dentist(boolean stud) {
        this.stud = stud;
    }

    public Dentist(String name, String surname, String education, String birthday, boolean stud) {
        super(name, surname, education, birthday);
        this.stud = stud;
    }

    public void cleanTooth(Pacient pacient) {
    }
}