package kivipaperisakset;

/**
 * Main-luokka.
 * Ajaa pelin
 * @author Sylvester Salo
 */
public class Main {

	
	/**
	 * Ajaa main metodin.
	 * @param args	Return args[]
	 */
	public static void main(String args[]) {
		
		Pelaaja p1 = new Pelaaja();
		Pelaaja p2 = new Pelaaja();
		
		KiviPaperiSakset kps = new KiviPaperiSakset();

		kps.pelaaPeli(p1, p2);
	}
	
	

}