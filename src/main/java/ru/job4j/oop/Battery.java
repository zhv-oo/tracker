package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void showLoad() {
        System.out.println(this.load);
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery one = new Battery(65);
        Battery two = new Battery(35);
        one.exchange(two);
        one.showLoad();
        two.showLoad();
    }
}