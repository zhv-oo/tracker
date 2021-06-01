package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball colobok = new Ball();
        Hare cosoy = new Hare();
        Wolf seryi = new Wolf();
        Fox hitraya = new Fox();
        cosoy.tryEat(colobok);
        colobok.canEscape();
        seryi.tryEat(colobok);
        colobok.canEscape();
        hitraya.tryEat(colobok);
        colobok.canEscape();
    }
}