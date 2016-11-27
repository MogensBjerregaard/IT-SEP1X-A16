package autoBus;

import java.io.Serializable;

public class Bus implements Serializable{

	private static final long serialVersionUID = 1L;
	private int maxNumberOfSeats;
	private int seatsAvailable;
	private String vehicleID;
	private double pricePerHour;
	private String model;
	private boolean availableForTours;
	
	public Bus(int maxNumberOfSeats, String vehicleID, double pricePerHour, String model){
		this.maxNumberOfSeats=maxNumberOfSeats;
		this.seatsAvailable=maxNumberOfSeats;
		this.vehicleID=vehicleID;
		this.pricePerHour=pricePerHour;
		this.model=model;
		this.availableForTours=true;
	}

	public int getMaxNumberOfSeats() {
		return maxNumberOfSeats;
	}

	public void setMaxNumberOfSeats(int maxNumberOfSeats) {
		this.maxNumberOfSeats = maxNumberOfSeats;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	
	public void removeSeat(){
		if (seatsAvailable>0){
			seatsAvailable--;
		}
	}
	
	public void addSeat(){
		if (seatsAvailable<maxNumberOfSeats){
			seatsAvailable++;
		}
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public String getModel() {
		return model;
	}
	
	public String getModelString() {
		return model.toString();
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isAvailableForTours() {
		return availableForTours;
	}

	public void setAvailableForTours(boolean availableForTours) {
		this.availableForTours = availableForTours;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
