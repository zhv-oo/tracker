package ru.job4j.oop;

public class Builder extends Engineer {
    private boolean someFloors;

    public Builder(boolean someFloors) {
        this.someFloors = someFloors;
    }

    public Builder(String name, String surname,
                   String education, String birthday, boolean someFloors) {
        super(name, surname, education, birthday);
        this.someFloors = someFloors;
    }

    public void canBuild(Build build) {
    }
}