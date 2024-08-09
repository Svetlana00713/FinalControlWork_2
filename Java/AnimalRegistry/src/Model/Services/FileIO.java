package Model.Services;
import Model.Animals;
import View.View;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class FileIO {
    public String SAVED_REGISTRY = "./animals_registry.txt";

    public List<Animals> fileAnimals;


    public FileIO(){
        this.fileAnimals = readFile(SAVED_REGISTRY);
    }

    public List<Animals> readFile(String filepath) {
        try {
            List<String> fileList = Files.readAllLines(Paths.get(filepath));
            if (fileList.size()>0){
                fileList.remove(0);
            }
            return Converter.convert(fileList);
        } catch(IOException e) {
            System.out.printf("Файл по пути %s не найден%n",filepath);
        }
        return List.of();
    }

    public boolean saveRegistry(Collection<Animals> animalList) {
        try(BufferedWriter wr = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(SAVED_REGISTRY), StandardCharsets.UTF_8)))
        {
            wr.write(View.TABLE_HEADER);
            wr.newLine();
            for (Animals a: animalList){
                wr.write(a.toString());
                wr.newLine();
            }
            return true;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
