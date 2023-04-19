package kivipaperisakset;

/**
 * KiviPaperiSakset-peli.
 * Luokka sisaltaa metodit KiviPaperiSakset-pelia varten.
 * @author Sylvester Salo
 */

public class KiviPaperiSakset {

	private int pelatutPelit = 0;
	private int tasapelit = 0;

	/**
	 * Pelaa pelia yhden eran. 
	 * Luodaan pelaajille uudet valinnat, tulostetaan tilanne, annetaan pisteet tilanteen mukaan ja kasvatetaan pelattujen pelien laskuria.
	 * 
	 * @param p1 Pelissa pelaavan Pelaaja 1:n esiintyma
	 * @param p2 Pelissa pelaavan Pelaaja 2:n esiintyma
	 * 
	 */
	public void pelaaEra(Pelaaja p1, Pelaaja p2) {
		p1.uusiValinta();
		p2.uusiValinta();
		tulostaTilanne(p1, p2);
		annaPisteet(p1, p2);
		pelatutPelit++;
	}

	/**
	 * Pelaa kokonainen peli. Pelataan eria kunnes jompikumpi pelaaja on voittanut 3
	 * kertaa.
	 * 
	 * @param p1 Pelissa pelaavan Pelaaja 1:n esiintyma
	 * @param p2 Pelissa pelaavan Pelaaja 2:n esiintyma
	 * 
	 */
	public void pelaaPeli(Pelaaja p1, Pelaaja p2) {
		boolean peliLoppui = false;
		do {
			pelaaEra(p1, p2);
			if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
				peliLoppui = true;
				System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
			}
		} while (!peliLoppui);

	}

	/**
	 * Jakaa pelaajille pisteet pelissa tapahtuneen tilanteen mukaan. Logiikka
	 * pisteiden jakamisille tapahtuu eri metodeissa. Jos tasapeli, kumpikaan
	 * pelaaja ei saa pistetta. Jos Pelaaja 1 voittaa, Pelaaja 1:n voittojen maaraa
	 * kasvatetaan. Jos Pelaaja 2 voittaa, Pelaaja 2:n voittojen maaraa kasvatetaan.
	 * 
	 * @see #onkoTasapeli(Pelaaja, Pelaaja)
	 * @see #voittikoP1(Pelaaja, Pelaaja)
	 * @param p1 Pelissa pelaavan Pelaaja 1:n esiintyma
	 * @param p2 Pelissa pelaavan Pelaaja 2:n esiintyma
	 * 
	 */
	public void annaPisteet(Pelaaja p1, Pelaaja p2) {
		if (onkoTasapeli(p1, p2)) {
		} else if (voittikoP1(p1, p2)) {
			p1.incrementVoitot();
			System.out.println("\nPelaaja 1 voittaa\n");
		} else {
			p2.incrementVoitot();
			System.out.println("\nPelaaja 2 voittaa\n");
		}
	}

	/**
	 * Logiikka pelaajien valintojen vertailuun.
	 * 
	 * @return true, jos Pelaaja 1:lla on voitollinen valinta.
	 * 
	 * @param p1 Pelissa pelaavan Pelaaja 1:n esiintyma
	 * @param p2 Pelissa pelaavan Pelaaja 2:n esiintyma
	 * 
	 */
	public boolean voittikoP1(Pelaaja p1, Pelaaja p2) {
		if (p1.getValinta().equals("kivi")) {
			return p2.getValinta().equals("sakset");
		} else if (p1.getValinta().equals("paperi")) {
			return p2.getValinta().equals("kivi");
		} else {
			return p2.getValinta().equals("paperi");
		}
	}

	/**
	 * Tarkistaa tapahtuiko erassa tasapeli. 
	 * Jos tapahtui tasapeli, kasvatetaan tasapelilaskuria yhdella.
	 * 
	 * @return true, jos Pelaaja 1:n valinta oli sama kuin Pelaaja 2:n valinta.
	 * 
	 * @param p1 Pelissa pelaavan Pelaaja 1:n esiintyma
	 * @param p2 Pelissa pelaavan Pelaaja 2:n esiintyma
	 * 
	 */
	public boolean onkoTasapeli(Pelaaja p1, Pelaaja p2) {
		if (p1.getValinta().equals(p2.getValinta())) {
			System.out.println("\nTasapeli\n");
			tasapelit++;
			return true;
		}
		return false;
	}

	/**
	 * Kuvaa pelin tilannetta. Auttaa seuraamaan pelin kulkua.
	 * 
	 * @param p1 Pelissa pelaavan Pelaaja 1:n esiintyma
	 * @param p2 Pelissa pelaavan Pelaaja 2:n esiintyma
	 * 
	 */
	public void tulostaTilanne(Pelaaja p1, Pelaaja p2) {
		System.out.println("Erä: " + pelatutPelit + " =====================\n");
		System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
		System.out
				.println("Pelaaja 1: " + p1.getValinta() + "\n\t Pelaaja 1:lla koossa " + p1.getVoitot() + " voittoa.");
		System.out
				.println("Pelaaja 2: " + p2.getValinta() + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
	}
}
