package autoBus;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CustomersArchive implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Customer> listOfCustomers;
    private String phoneNumber;

    public CustomersArchive() {
        this.listOfCustomers = new ArrayList<>();
    }

    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public void setListOfCustomers(ArrayList<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }



    public Customer get(String name){
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if(listOfCustomers.get(i).getName().equals(name)){
                return listOfCustomers.get(i);
            }
        }
        return null;
    }

    public void add(Customer newCustomer){
        listOfCustomers.add(newCustomer);
    }

    public void remove(String name){
        for (int i = 0; i < listOfCustomers.size(); i++) {
            if(listOfCustomers.get(i).getName().equals(name)){
                listOfCustomers.remove(i);
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
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\AutoBus\\CustomersArchive.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        try {
            objectOutputStream.writeObject(listOfCustomers);
        } finally {
            objectOutputStream.close();
        }
    }

    public void load() throws Exception{
        FileInputStream fileInputStream = new FileInputStream("C:\\AutoBus\\CustomersArchive.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            this.listOfCustomers = (ArrayList<Customer>)objectInputStream.readObject();
        } finally {
            objectInputStream.close();
        }
    }

    public boolean isFileFound(){
        Path path = Paths.get("C:\\AutoBus\\CustomersArchive.dat");
        return (Files.exists(path));
    }

    public void createFile() throws Exception{
        listOfCustomers.add(new Customer("","","","",new Date(0,0,0)));
        save();
        listOfCustomers.remove(0);
        save();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Customer customer: listOfCustomers){
            builder.append(customer.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}
