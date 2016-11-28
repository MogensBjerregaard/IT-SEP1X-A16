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

public class PriceList implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Double> priceList;
	private double priceBreakfast; //index 0
	private double priceLunch; //index 1
	private double priceAllInclusive; //index 2
	private double priceEntranceTickets; //index 3
	
	public PriceList() throws Exception {
		this.priceBreakfast = 0;
		this.priceLunch = 0;
		this.priceAllInclusive = 0;
		this.priceEntranceTickets = 0;
		this.priceList = new ArrayList<Double>();
		if (isFileFound()) {
			loadPriceList();
		} else {
			createFile();
		}
		
	}
	
	public boolean isFileFound(){
		Path path = Paths.get("C:\\Autobus\\PriceList.dat");
		return (Files.exists(path));
	}
	
	public void createFile() throws Exception{
		priceList.add(priceBreakfast);
		priceList.add(priceLunch);
		priceList.add(priceAllInclusive);
		priceList.add(priceEntranceTickets);
		savePriceList();
	}
	
	public void savePriceList() throws Exception{
		Path path = Paths.get("C:\\Autobus");
		if (!Files.exists(path)){
			try {
				Files.createDirectory(path);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error: Unable to create directory!");
			}		
		}
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Autobus\\PriceList.dat");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		try {
			objectOutputStream.writeObject(priceList);
		} finally {
			objectOutputStream.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadPriceList() throws Exception{
		FileInputStream fileInputStream = new FileInputStream("C:\\Autobus\\PriceList.dat");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			ArrayList<Double> otherPriceList = (ArrayList<Double>)objectInputStream.readObject();//how to check if instance of ArrayList<Double>??
			this.priceList=otherPriceList;
		} finally {
			objectInputStream.close();
		}
	}
	
	public double getPriceBreakfast() {
		return priceBreakfast;
	}

	public void setPriceBreakfast(double priceBreakfast) {
		this.priceBreakfast = priceBreakfast;
	}

	public double getPriceLunch() {
		return priceLunch;
	}

	public void setPriceLunch(double priceLunch) {
		this.priceLunch = priceLunch;
	}

	public double getPriceAllInclusive() {
		return priceAllInclusive;
	}

	public void setPriceAllInclusive(double priceAllInclusive) {
		this.priceAllInclusive = priceAllInclusive;
	}

	public double getPriceEntranceTickets() {
		return priceEntranceTickets;
	}

	public void setPriceEntranceTickets(double priceEntranceTickets) {
		this.priceEntranceTickets = priceEntranceTickets;
	}
		
	
}
