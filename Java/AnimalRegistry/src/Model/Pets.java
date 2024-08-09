package Model;

import java.util.ArrayList;

public abstract class Pets extends Animals{
    protected String groupName ;

    public Pets(int Id,String animalName , String birthDate, ArrayList<String> commands){
        super(Id,animalName,birthDate,commands);
        this.groupName = "Домашнее";
    }
}
