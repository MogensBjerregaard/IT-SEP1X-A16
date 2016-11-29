package autoBus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BusesArchive implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Bus> busesArchive;
	
	public BusesArchive(){
		busesArchive=new ArrayList<Bus>();
	}
	
	public int size(){
		return busesArchive.size();
	}
	
	public Bus get(int index){
		return busesArchive.get(index);
	}
	
	public void addBus(Bus bus){
		busesArchive.add(bus);
	}
	
	public void removeBus(int index){
		busesArchive.remove(index);
	}
	
	public boolean isFileFound(){
		Path path = Paths.get("C:\\AutoBus\\BusesArchive.dat");
		return (Files.exists(path));
	}
	
	public void createFile() throws Exception{
		addBus(new Bus(0, "", 0, ""));
		saveBusesArchive();
		busesArchive.remove(0);
		saveBusesArchive();
	}
	
	public void saveBusesArchive() throws Exception{
		Path path = Paths.get("C:\\AutoBus");
		if (!Files.exists(path)){
			try {
				Files.createDirectory(path);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error: Unable to create directory!");
			}		
		}
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\AutoBus\\BusesArchive.dat");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		try {
			objectOutputStream.writeObject(busesArchive);
		} finally {
			objectOutputStream.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void loadBusesArchive() throws Exception{
		FileInputStream fileInputStream = new FileInputStream("C:\\AutoBus\\BusesArchive.dat");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			ArrayList<Bus> otherBusesArchive = (ArrayList<Bus>)objectInputStream.readObject();//how to check if instance of ArrayList<Bus>??
			this.busesArchive=otherBusesArchive;
		} finally {
			objectInputStream.close();
		}
	}
	
	
}
