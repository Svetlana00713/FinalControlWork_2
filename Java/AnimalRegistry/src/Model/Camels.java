package Model;

import View.Menu;

import java.util.ArrayList;
import java.util.Arrays;

public class Camels extends PackAnimals{
    protected String species;
    public Camels(int Id,String animalName, String birthDate, String commands) {
        super( Id,
                animalName,
                birthDate,
                new ArrayList<>(Arrays.asList(commands.split(SPLIT_REGEX))));
        this.species = "Верблюд";
    }
    @Override
    public String toString() {
        return String.format( Menu.TABLE_ROW,
                this.Id,
                this.topName,
                this.groupName,
                this.species,
                this.animalName,
                this.birthDate,
                String.join(" ",commands));
    }
}
