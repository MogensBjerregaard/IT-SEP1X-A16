package autoBus;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numberOfReservations;
    private String phoneNumber;

    public Customer(String name,String phoneNumber, String email, String address, Date birthday) {
        super(name, email, address, birthday);
        this.numberOfReservations = 0;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfReservations() {
        return numberOfReservations;
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " +
                ", address: " + address +
                ", birthday= " + birthday +
                ", phoneNumber= " + phoneNumber +
                ", number of reservations = " + numberOfReservations;
    }

}
