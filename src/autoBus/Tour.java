package autoBus;

import java.io.Serializable;
import java.util.ArrayList;

public class Tour implements Serializable{

	private static final long serialVersionUID = 1L;
	private	String destination;
	private	ArrayList<String> pickUpPlaces;
	private double pricePerPassenger;
	private	Services services;
	private	Chauffeur chauffeur;
	private	Bus bus;
	private DateInterval dateInterval;

	/*TESTING CONSTRUCTOR*/public Tour(Bus bus){
	   this.bus = bus;
	}
	
	public Tour(String destination, ArrayList<String> pickUpPlaces, double pricePerPassenger, Services services, Chauffeur chauffeur, Bus bus, DateInterval dateInterval) {
		this.destination = destination;
		this.pickUpPlaces = pickUpPlaces;
		this.pricePerPassenger = pricePerPassenger;
		this.services = services;
		this.chauffeur = chauffeur;
		this.bus = bus;
		this.dateInterval = dateInterval;
	}

	public Chauffeur getChauffeur() {
		return chauffeur;
	}

	public Bus getBus() {
		return bus;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public ArrayList<String> getPickUpPlaces() {
			return pickUpPlaces;
		}
		
		public String getPickUpPlacesString(){
			String str = new String("");
			for (String string : pickUpPlaces) {
				str += string + "\n";
			}
			if (!str.equalsIgnoreCase("")) {
				return str;
			} else {
				return null;
			}
		}

		public void setPickUpPlaces(String pickUpPlace) {
			this.pickUpPlaces.add(pickUpPlace);
		}

		public double getPricePerPassenger() {
			return pricePerPassenger;
		}

		public void setPricePerPassenger(double pricePerPassenger) {
			this.pricePerPassenger = pricePerPassenger;
		}

		public Services getServices() {
			return services;
		}

		public void setServices(Services services) {
			this.services = services;
		}

		public DateInterval getDateInterval() {
			return dateInterval;
		}

		public void setDateInterval(DateInterval dateInterval) {
			this.dateInterval = dateInterval;
		}
		
		

}
