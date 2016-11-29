package autoBus;

import java.util.ArrayList;

public abstract class Reservation {
    private String RESERVATION_ID; //CAN WE SOMEHOW MAKE THIS FIELD FINAL?

    private double discount;

    private Customer customer;

    private ArrayList<Passenger> listOfPassengers;


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
        return  RESERVATION_ID + ": " + customer;

    }

}
