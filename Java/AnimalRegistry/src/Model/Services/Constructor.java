package Model.Services;

import Model.*;
import Presenter.AddException;
import View.DataValidator;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Constructor {
    DataValidator dv;

    public Constructor(){
        this.dv = new DataValidator();
    }
    public Animals createAnimal(int Id,int classChoice, ArrayList<String> data) throws AddException,DateTimeParseException {
        String bd = dv.formatDate(data.get(1));
        return switch (classChoice) {
            case 1 -> new Cats(Id, data.get(0), bd, data.get(2));
            case 2 -> new Dogs(Id, data.get(0), bd, data.get(2));
            case 3 -> new Hamsters(Id, data.get(0), bd, data.get(2));
            case 4 -> new Horses(Id, data.get(0), bd, data.get(2));
            case 5 -> new Donkeys(Id, data.get(0), bd, data.get(2));
            case 6 -> new Camels(Id, data.get(0), bd, data.get(2));
            default -> throw new AddException();
        };
    }
}
