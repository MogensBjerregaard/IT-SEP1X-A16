package autoBus;

import java.io.Serializable;
import java.util.ArrayList;

public class Tour implements Serializable{

	private static final long serialVersionUID = 1L;
		String destination;
		ArrayList<String> pickUpPlaces;
		double pricePerPassenger;
		Services services;
		ChauffeursArchive chauffeursArchive;
		BusesArchive busesArchive;
		DateInterval dateInterval;
		
		public Tour(String destination) throws Exception{
			this.destination=destination;
			pickUpPlaces = new ArrayList<>();
			pricePerPassenger = 0;
			services = new Services();
			chauffeursArchive = new ChauffeursArchive();
			busesArchive = new BusesArchive();
			dateInterval = new DateInterval();
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
