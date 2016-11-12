
package autoBus;

/**
 * @author IT-1X-A16 Group 1: Mogens Bjerregaard, Adam Kounis, Eugene Maloman, Nicolai Onov
 *
 */
public class AutoBusApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//test chauffeurArchive:
		ChauffeursArchive chauffeursArchive = new ChauffeursArchive();
		/*
		chauffeursArchive.addChauffeur(new Chauffeur("Mogens", "Bjerregaard"));
		chauffeursArchive.addChauffeur(new Chauffeur("Nicolai", "Onov"));
		chauffeursArchive.addChauffeur(new Chauffeur("Eugene", "Maloman"));
		chauffeursArchive.addChauffeur(new Chauffeur("Adam", "Kounis"));
		chauffeursArchive.saveChauffeursArchive();
		*/
		chauffeursArchive.loadChauffeursArchive();
		//System.out.println(chauffeursArchive.toString());
		chauffeursArchive.addChauffeur(new Chauffeur("Mogens", "Bjerregaard"));
		chauffeursArchive.addChauffeur(new Chauffeur("Nicolai", "Onov"));
		chauffeursArchive.addChauffeur(new Chauffeur("Eugene", "Maloman"));
		chauffeursArchive.addChauffeur(new Chauffeur("Adam", "Kounis"));
		chauffeursArchive.saveChauffeursArchive();
		System.out.println(chauffeursArchive.toString());
	}

}
