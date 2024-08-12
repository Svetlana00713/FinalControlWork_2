package View;
import Model.Animals;
import java.util.Collection;
import java.util.Scanner;

public class Menu {
    public static final String TABLE_ROW = "|%3s|%-8s|%8s|%-10s|%-12s|%10s|%-40s|";
    public static final String TABLE_HEADER = String.format(TABLE_ROW
            , "id"
            , "Класс"
            , "Группа"
            , "Вид"
            , "Кличка"
            , "Дата рожд."
            , "Команды"
    );

    public static final String TABLE_BORDER = String.format("+%3s+%8s+%8s+%10s+%12s+%10s+%40s+"
            , "-".repeat(3)
            , "-".repeat(8)
            , "-".repeat(8)
            , "-".repeat(10)
            , "-".repeat(12)
            , "-".repeat(10)
            , "-".repeat(40));

    Scanner scan;

    public Menu(){
        this.scan = new Scanner(System.in);
    }

    public void showIntro(){
        System.out.println("Добро пожаловать в наш питомник! ");
        System.out.println("Для навигации введите номер нужной операции и нажмите Enter");
    }

    public void showOutro(){
        System.out.println("Работа завершена");
        System.out.println("Всего доброго!");
    }


    public void showMainMenu() {
        System.out.println();
        System.out.println("1 - вывести список животных");
        System.out.println("2 - добавить новое животное");
        System.out.println("3 - показать конкретное животное");
        System.out.println("4 - сохранить изменения");
        System.out.println("5 - закончить посещение");
    }

    public void showAnimalMenu(Animals a){
        System.out.println("Вы работаете с животным:");
        System.out.println(a);
        System.out.println("1 - научить новым командам");
        System.out.println("2 - удалить из реестра");
        System.out.println("3 - вернуться в главное меню");
    }

    public void wrongMenu(){
        System.out.println("Неверный номер операции,повторите ввод");
    }
    public Integer IdFromUser(){
        System.out.print("Введите id животного: ");
        return Integer.parseInt(scan.nextLine()) ;
    }

    public String askNewCommand(){
        System.out.print("Введите новую команду: ");
        return scan.nextLine();
    }

    public void operationResult(boolean res){
        if(res){
            System.out.println("Операция успешно завершена");
        }
    }

    public int classMenu(){
        System.out.println("Выберите, какое животное вы хотите добавить");
        System.out.println("1 - Кошка");
        System.out.println("2 - Собака");
        System.out.println("3 - Хомяк");
        System.out.println("4 - Лошадь");
        System.out.println("5 - Осел");
        System.out.println("6 - Верблюд");
        return menuChoice();
    }

    public int menuChoice() {
        System.out.print("Ваш выбор: ");
        String inputLine = scan.nextLine();
        return switch (inputLine) {
            case ("1") -> 1;
            case ("2") -> 2;
            case ("3") -> 3;
            case ("4") -> 4;
            case ("5") -> 5;
            case ("6") -> 6;
            default -> 0;
        };
    }

    public String newAnimalInput(){
        System.out.println("Введите имя, дату рождения, выученные команды животного через пробел:");
        return scan.nextLine();
    }

    private void printTableLine() {
        System.out.println(TABLE_BORDER);
    }

    public void printDB(Collection<Animals> animalsList) {
        printTableLine();
        System.out.println(TABLE_HEADER);
        for (Animals animals: animalsList) {
            System.out.println(animals);
        }
        printTableLine();
    }

    public void wrongId(int id){
        System.out.printf("Записи с id-номером %d нет в реестре%n",id);
    }
}
