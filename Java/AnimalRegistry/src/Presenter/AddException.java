package Presenter;

public class AddException extends RuntimeException{
    public AddException() {
        super("Класса такого вида еще нет в иерархии");
    }
}
