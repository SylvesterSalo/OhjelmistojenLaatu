package kivipaperisakset;

/**
 * Pelaaja-olio.
 * Toimii pelaajana KiviPaperiSakset -pelissa
 * @author Sylvester Salo
 */
public class Pelaaja {

	private int voitot;
	private String valinta;

	/**
	 * Asettaa pelaajalle satunnaisesti uuden valinnan (kivi, paperi tai sakset).
	 * 
	 */
	public void uusiValinta() {
		String uusiValinta = "";
		int c = (int) (Math.random() * 3);
		switch (c) {
		case 0:
			uusiValinta = "kivi";
			break;
		case 1:
			uusiValinta = "paperi";
			break;
		case 2:
			uusiValinta = "sakset";
			break;
		}
		this.valinta = uusiValinta;
	}

	/**
	 * Asettaa pelaajalle parametrina annetun valinnan.
	 * @param valinta Asetettava valinta
	 */
	public void setValinta(String valinta) {
		this.valinta = valinta;
	}

	/**
	 * Palauttaa pelaajan valinnan.
	 * @return valinta
	 */
	public String getValinta() {
		return valinta;
	}

	/**
	 * Kasvattaa pelaajan voittojen maaraa.
	 * @return voitot
	 */
	public int incrementVoitot() {
		return voitot++;
	}

	/**
	 * Palauttaa pelaajan voittojen maaran.
	 * @return voitot
	 */
	public int getVoitot() {
		return voitot;
	}

}