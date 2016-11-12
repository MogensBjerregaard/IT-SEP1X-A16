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

public class ChauffeursArchive implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Chauffeur> chauffeursArchive;
	
	public ChauffeursArchive(){
		chauffeursArchive=new ArrayList<Chauffeur>();
	}
	
	public void addChauffeur(Chauffeur chauffeur){
		chauffeursArchive.add(chauffeur);
	}
	
	public void saveChauffeursArchive() throws Exception{
		Path path = Paths.get("C:\\AutoBus");
		if (!Files.exists(path)){
			try {
				Files.createDirectory(path);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error: Unable to create directory!");
			}		
		}
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\AutoBus\\ChauffeursArchive.dat");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		try {
			objectOutputStream.writeObject(chauffeursArchive);
		} finally {
			objectOutputStream.close();
		}
	}
	
	public void loadChauffeursArchive() throws Exception{
		FileInputStream fileInputStream = new FileInputStream("C:\\AutoBus\\ChauffeursArchive.dat");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			ArrayList<Chauffeur> otherChauffeursArchive = (ArrayList<Chauffeur>)objectInputStream.readObject();//how to check if instance of ArrayList<Chauffeur>??
			this.chauffeursArchive=otherChauffeursArchive;
		} finally {
			objectInputStream.close();
		}
	}
	
	public String toString(){
		String str = new String();
		for (int i=0; i<chauffeursArchive.size();i++){
			str=str+chauffeursArchive.get(i).getFirstName()+" "+chauffeursArchive.get(i).getLastName()+"\n";
		}
		return str;
	}
}
