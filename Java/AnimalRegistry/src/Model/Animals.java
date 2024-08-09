package Model;

import java.util.ArrayList;

public abstract class Animals {
    protected  int Id;
    public static final String SPLIT_REGEX = "[ ,]";
    protected String topName;
    protected String animalName;
    protected String birthDate;
    protected ArrayList<String> commands;

    public Animals(int Id, String animalName,String birthDate, ArrayList<String> commands) {
        this.Id = Id;
        this.animalName = animalName;
        this.birthDate = birthDate;
        this.commands = commands;
        this.topName = "Животное";
    }

    public int getId() {
        return Id;
    }

    public void setCommands(String newCommand) {
        this.commands.add(newCommand);
    }

}
