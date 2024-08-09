package Model.Services;
import Model.*;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    final static String DELIMITER = "[| ]+";
    public static List<Animals> convert(List<String> stringData ){
        List<Animals> result = new ArrayList<>(stringData.size());
        for (String line:stringData){
            line = line.replaceFirst(DELIMITER,"").replaceAll(DELIMITER+"$","");
            String[] animalFields = line.split(DELIMITER,7);
            switch (animalFields[3]) {
                case "Кошка" ->
                        result.add(new Cats(Integer.parseInt(animalFields[0]), animalFields[4], animalFields[5], animalFields[6]));
                case "Собака" ->
                        result.add(new Dogs(Integer.parseInt(animalFields[0]), animalFields[4], animalFields[5], animalFields[6]));
                case "Хомяк" ->
                        result.add(new Hamsters(Integer.parseInt(animalFields[0]), animalFields[4], animalFields[5], animalFields[6]));
                case "Лошадь" ->
                        result.add(new Horses(Integer.parseInt(animalFields[0]), animalFields[4], animalFields[5], animalFields[6]));
                case "Осёл" ->
                        result.add(new Donkeys(Integer.parseInt(animalFields[0]), animalFields[4], animalFields[5], animalFields[6]));
                case "Верблюд" ->
                        result.add(new Camels(Integer.parseInt(animalFields[0]), animalFields[4], animalFields[5], animalFields[6]));
                default -> System.out.printf("%s такой вид животного не найден, запись пропущена", animalFields[3]);
            }
        }
        return result;
    }
}
