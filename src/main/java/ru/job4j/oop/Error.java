package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.print("Активная: " + active);
        System.out.print(" Статус: " + status);
        System.out.println(" Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error err1 = new Error();
        Error err2 = new Error(true, 0, "bad");
        Error err3 = new Error(false, 1, "-1");
        Error err4 = new Error(true, 0, "Please reboot");
        err1.printError();
        err2.printError();
        err3.printError();
        err4.printError();
    }
}
