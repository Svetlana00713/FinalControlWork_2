package Controller;
import Model.Animals;
import Model.Services.*;

import View.View;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Controller {
    HashMap<Integer, Animals> currentReg;
    private final Constructor constructor;
    private final View view;
    private final FileIO f;

    public Controller() {
        this.constructor = new Constructor();
        this.view = new View();
        this.f = new FileIO();
        this.currentReg = (HashMap<Integer, Animals>) f.fileAnimals
                .stream().collect(Collectors.toMap(Animals::getId, Function.identity()));
    }

    public void start(){
        view.showIntro();
        menuLoop();
    }

    public void menuLoop(){

        int counterStart = currentReg.isEmpty() ? 0 : Collections.max(currentReg.keySet());  //счетчик инициализируем с максимальным существующим Id
        try( Counter c = new Counter(counterStart) ) {
            int choice;
            boolean loop = true;
            while(loop){
                view.showMainMenu();
                choice = view.menuChoice();
                switch (choice) {
                    case 1 -> showAll();
                    case 2 -> view.operationResult(addAnimal(c));
                    case 3 -> view.operationResult(oneAnimalMenu());
                    case 4 -> view.operationResult(f.saveRegistry(currentReg.values()));
                    case 5 -> loop = false;
                    default -> view.wrongMenu();
                }
            }
        } catch (CounterException e){
            System.out.println( e.getMessage());
        }
        view.showOutro();
        System.exit(0);
    }

    public boolean addAnimal(Counter c) throws CounterException{
        int classChoice = view.classMenu();
        ArrayList<String> animalData = new ArrayList<>(List.of(
                view.newAnimalInput().split(" ", 3))) ;
        try
        {
            int Id = c.add(animalData.size()); //место возможного CounterException
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
        int userId = view.IdFromUser();
        Animals a = currentReg.get(userId);
        if (a == null){
            view.wrongId(userId);
            return false;
        }
        int choice;
        boolean loop = true;
        while(loop){
            view.showAnimalMenu(a);
            choice = view.menuChoice();
            switch (choice) {
                case 1 -> a.setCommands(view.askNewCommand());
                case 2 -> {
                    currentReg.remove(a.getId());
                    return true;
                }
                case 3 -> loop=false;
                default -> view.wrongMenu();
            }
        }
        return false;
    }
    public void showAll() {
        view.printDB(currentReg.values());
        menuLoop();
    }
}
