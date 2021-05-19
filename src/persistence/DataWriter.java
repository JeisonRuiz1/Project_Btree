package persistence;

import model.Person;
import model.Tree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataWriter <T>{

    public static  final  String PATH_FILE = "src/resources/data/data.info";

    public void writeDataFile(Tree<T> dataTree){

        Tree<T> tree = dataTree;
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(PATH_FILE))){
            oss.writeObject(tree);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
