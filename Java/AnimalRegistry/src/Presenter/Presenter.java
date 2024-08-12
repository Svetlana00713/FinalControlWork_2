package Presenter;
import Model.Animals;
import Model.Services.*;

import View.Menu;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Presenter {
    HashMap<Integer, Animals> currentReg;
    private final Constructor constructor;
    private final Menu menu;
    private final FileIO f;

    public Presenter() {
        this.constructor = new Constructor ();
        this.menu = new Menu ();
        this.f = new FileIO ();
        this.currentReg = (HashMap<Integer, Animals>) f.fileAnimals
                .stream().collect(Collectors.toMap(Animals::getId, Function.identity()));
    }

    public void start(){
        menu.showIntro();
        menuLoop();
    }

    public void menuLoop(){

        int counterStart = currentReg.isEmpty() ? 0 : Collections.max(currentReg.keySet());  //счетчик инициализируем с максимальным существующим Id
        try( Counter c = new Counter(counterStart) ) {
            int choice;
            boolean loop = true;
            while(loop){
                menu.showMainMenu();
                choice = menu.menuChoice();
                switch (choice) {
                    case 1 -> showAll();
                    case 2 -> menu.operationResult(addAnimal(c));
                    case 3 -> menu.operationResult(oneAnimalMenu());
                    case 4 -> menu.operationResult(f.saveRegistry(currentReg.values()));
                    case 5 -> loop = false;
                    default -> menu.wrongMenu();
                }
            }
        } catch (CounterException e){
            System.out.println( e.getMessage());
        }
        menu.showOutro();
        System.exit(0);
    }

    public boolean addAnimal(Counter c) throws CounterException{
        int classChoice = menu.classMenu();
        ArrayList<String> animalData = new ArrayList<>(List.of(
                menu.newAnimalInput().split(" ", 3))) ;
        try
        {
            int Id = c.add(animalData.size());
            Animals a = constructor.createAnimal(Id,classChoice, animalData);
            if(a != null){
                currentReg.put(a.getId(),a);
                return true;
            }
        } catch(AddException | DateTimeParseException e){
            System.out.println( e.getMessage());
            return false;
        }
        return false;
    }

    public boolean oneAnimalMenu(){
        int userId = menu.IdFromUser();
        Animals a = currentReg.get(userId);
        if (a == null){
            menu.wrongId(userId);
            return false;
        }
        int choice;
        boolean loop = true;
        while(loop){
            menu.showAnimalMenu(a);
            choice = menu.menuChoice();
            switch (choice) {
                case 1 -> a.setCommands( menu.askNewCommand());
                case 2 -> {
                    currentReg.remove(a.getId());
                    return true;
                }
                case 3 -> loop=false;
                default -> menu.wrongMenu();
            }
        }
        return false;
    }
    public void showAll() {
        menu.printDB(currentReg.values());
        menuLoop();
    }
}
