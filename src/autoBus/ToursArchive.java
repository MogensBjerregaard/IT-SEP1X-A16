package autoBus;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ToursArchive implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Tour> listOfTours;

    public ToursArchive() {
        this.listOfTours = new ArrayList<>();
    }

    public ArrayList<Tour> getListOfTours(){
		return this.listOfTours;
	}
	
	 public Tour get(String destination){
	        for (int i = 0; i < listOfTours.size(); i++) {
	            if(listOfTours.get(i).getDestination().equals(destination)){
	                return listOfTours.get(i);
	            }
	        }
	        return null;
	    }

	    public void add(Tour newTour){
	        listOfTours.add(newTour);
	    }

	    public void remove(Tour tour){
	        for (int i = 0; i < listOfTours.size(); i++) {
	            if(listOfTours.get(i).equals(tour)){
	                listOfTours.remove(i);
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
	        FileOutputStream fileOutputStream = new FileOutputStream("C:\\AutoBus\\ToursArchive.dat");
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        try {
	            objectOutputStream.writeObject(listOfTours);
	        } finally {
	            objectOutputStream.close();
	        }
	    }

	    public void load() throws Exception{
	        FileInputStream fileInputStream = new FileInputStream("C:\\AutoBus\\ToursArchive.dat");
	        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	        try {
	            this.listOfTours = (ArrayList<Tour>)objectInputStream.readObject();
	        } finally {
	            objectInputStream.close();
	        }
	    }

	    public String toString(){
	        StringBuilder builder = new StringBuilder();
	        for (Tour tour: listOfTours){
	            builder.append(tour.toString());
	            builder.append("\n");
	        }
	        return builder.toString();
	    }

    public boolean isFileFound(){
        Path path = Paths.get("C:\\AutoBus\\ToursArchive.dat");
        return (Files.exists(path));
    }

    public void createFile() throws Exception{
        listOfTours.add(new Tour("",new ArrayList<String>(),0,new Services(),new Chauffeur(),new Bus(), new DateInterval()));
        save();
        listOfTours.remove(0);
        save();
    }
}
