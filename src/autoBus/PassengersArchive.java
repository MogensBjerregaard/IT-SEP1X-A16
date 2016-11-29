package autoBus;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by lenovo on 11/29/2016.
 */
public class PassengersArchive implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Passenger> listOfPassengers;

    public ArrayList<Passenger> getListOfPassengers() {
        return listOfPassengers;
    }

    public PassengersArchive() {
        this.listOfPassengers = new ArrayList<>();
    }


    public Passenger get(String name){
        for (int i = 0; i < listOfPassengers.size(); i++) {
            if(listOfPassengers.get(i).getName().equals(name)){
                return listOfPassengers.get(i);
            }
        }
        return null;
    }

    public void add(Passenger newPassenger){
        listOfPassengers.add(newPassenger);
    }

    public void remove(String name){
        for (int i = 0; i < listOfPassengers.size(); i++) {
            if(listOfPassengers.get(i).getName().equals(name)){
                listOfPassengers.remove(i);
            }
        }
    }
    public void save() throws Exception{
        Path path = Paths.get("C:\\AutoBus");
        if (!Files.exists(path)){
            try {
                Files.createDirectory(path);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Unable to create directory!");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\AutoBus\\PassengersArchive.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            objectOutputStream.writeObject(listOfPassengers);
        } finally {
            objectOutputStream.close();
        }
    }

    public void load() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("C:\\AutoBus\\PassengersArchive.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            this.listOfPassengers = (ArrayList<Passenger>)objectInputStream.readObject();
        } finally {
            objectInputStream.close();
        }
    }

    public boolean isFileFound(){
        Path path = Paths.get("C:\\AutoBus\\PassengersArchive.dat");
        return (Files.exists(path));
    }

    public void createFile() throws Exception{
        listOfPassengers.add(new Passenger("","","",new Date(0,0,0)));
        save();
        listOfPassengers.remove(0);
        save();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Passenger passenger: listOfPassengers){
            builder.append(passenger.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
