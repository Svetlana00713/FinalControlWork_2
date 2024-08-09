package Model;

import View.View;

import java.util.ArrayList;
import java.util.Arrays;

public class Dogs extends Pets {
    private final String species;

    public Dogs(int Id,String animalName, String birthDate, String commands) {
        super(  Id,
                animalName,
                birthDate,
                new ArrayList<>(Arrays.asList(commands.split(SPLIT_REGEX))));
        this.species = "Собака";

    }
    @Override
    public String toString() {
        return String.format(View.TABLE_ROW,
                this.Id,
                this.topName,
                this.groupName,
                this.species,
                this.animalName,
                this.birthDate,
                String.join(" ",commands));
    }
}
