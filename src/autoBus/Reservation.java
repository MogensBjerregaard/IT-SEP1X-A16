package autoBus;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Reservation implements Serializable {
    /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private String RESERVATION_ID; //CAN WE SOMEHOW MAKE THIS FIELD FINAL?

   private Tour tour;
    private double discount;

    private Customer customer;

    private ArrayList<Passenger> listOfPassengers;
    
    public Reservation() {
       
    }

    
    public Reservation(String RESERVATION_ID, double discount, Customer customer, ArrayList<Passenger> listOfPassengers, Tour tour) {
        this.RESERVATION_ID = RESERVATION_ID;
        this.discount = discount;
        this.customer = customer;
        this.listOfPassengers = listOfPassengers;
        this.tour = tour;
    }
    
    public Tour getTour(){
       return this.tour;
    }
    
    public void setTour(Tour newTour){
       this.tour = newTour;
    }

    public String getRESERVATION_ID() {
        return RESERVATION_ID;
    }
    public double getDiscount() {
        return discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Passenger> getListOfPassengers() {
        return listOfPassengers;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setListOfPassengers(ArrayList<Passenger> listOfPassengers) {
        this.listOfPassengers = listOfPassengers;
    }

    @Override
    public String toString() {
        return  RESERVATION_ID + ": " + customer.toString();

    }

}
