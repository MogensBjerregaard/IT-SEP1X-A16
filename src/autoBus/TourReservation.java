package autoBus;

import java.io.Serializable;
import java.util.ArrayList;

public class TourReservation extends Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Tour tour;

    public TourReservation(String RESERVATION_ID, double discount, Customer customer, ArrayList<Passenger> listOfPassengers, Tour tour) {
        super(RESERVATION_ID, discount, customer, listOfPassengers);
        this.tour = tour;
    }

}
