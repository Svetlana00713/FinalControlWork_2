package Model;

import java.util.ArrayList;

public abstract class PackAnimals extends Animals{
    protected String groupName ;

    public PackAnimals(int Id,String animalName , String birthDate, ArrayList<String> commands){
        super(Id,animalName,birthDate,commands);
        this.groupName = "Вьючное";
    }
}
