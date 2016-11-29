package autoBus;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReservationsArchive {
    private ArrayList<Reservation> listOfReservations;

    public Reservation get(String RESERVATION_ID){
        for (int i = 0; i < listOfReservations.size(); i++) {
            if(listOfReservations.get(i).getRESERVATION_ID().equals(RESERVATION_ID)){
                return listOfReservations.get(i);
            }
        }
        return null;
    }

    public void add(Reservation newReservation){
        listOfReservations.add(newReservation);
    }

    public void remove(String RESERVATION_ID){
        for (int i = 0; i < listOfReservations.size(); i++) {
            if(listOfReservations.get(i).getRESERVATION_ID().equals(RESERVATION_ID)){
                listOfReservations.remove(i);
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
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\AutoBus\\ReservationsArchive.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            objectOutputStream.writeObject(listOfReservations);
        } finally {
            objectOutputStream.close();
        }
    }

    public void load() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("C:\\AutoBus\\ReservationsArchive.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            this.listOfReservations = (ArrayList<Reservation>)objectInputStream.readObject();
        } finally {
            objectInputStream.close();
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Reservation reservation: listOfReservations){
            builder.append(reservation.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}
