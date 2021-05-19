package persistence;

import model.Person;
import model.Tree;

import java.io.*;

public class DataReader<T> {

    public static  final  String PATH_FILE = "src/resources/data/data.info";

    public void readData() throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_FILE)) ){
            Tree<Person> myTree = (Tree<Person>) ois.readObject();
            System.out.println(myTree.getHeight());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
