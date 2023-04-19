package kivipaperisakset;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KiviPaperiSaksetTest {

	KiviPaperiSakset kps = new KiviPaperiSakset();
	Pelaaja p1 = new Pelaaja();
	Pelaaja p2 = new Pelaaja();
	
	@Test
	@DisplayName("voittikoP1(): toimiiko pelilogiikka oikein")
	void testVoittikoP1() {
		p1.setValinta("kivi");
		p2.setValinta("sakset");
		assertTrue(kps.voittikoP1(p1, p2), "Pelilogiikka ei toimi oikein");
	}

	@Test
	@DisplayName("onkoTasapeli(): toimiiko tasapelit oikein")
	void testOnkoTasapeli() {
		p1.setValinta("kivi");
		p2.setValinta("kivi");
		assertTrue(kps.onkoTasapeli(p1, p2), "Tasapelilogiikka ei toimi oikein");
	}
	
	@Test
	@DisplayName("pelaaEra()")
	void testPelaaEra() {
		kps.pelaaEra(p1, p2);
		assertTrue((p1.getVoitot() == 1 || p2.getVoitot() == 1 || kps.onkoTasapeli(p1,p2)), "Erän jälkeen jommallakummalla pelaajalla tulisi olla 1 piste, jos tasapeli niin kummallakaan ei tulisi olla pistettä");
	}
	
	@Test
	@DisplayName("pelaaPeli()")
	void testPelaaPeli() {
		kps.pelaaPeli(p1, p2);
		assertTrue((p1.getVoitot() == 3 || p2.getVoitot() == 3), "Pelin jälkeen jommallakummalla pelaajalla tulisi olla 3 pistettä voitettuna");
	}
	
	@Test
	@DisplayName("annaPisteet(): toimiiko pisteytys oikein")
	void testAnnaPisteet() {
		p1.setValinta("kivi");
		p2.setValinta("kivi");
		kps.annaPisteet(p1, p2);
		assertTrue((p1.getVoitot() == 0 && p2.getVoitot() == 0), "Pisteitä ei kuuluisi jakaa tasapelitilanteessa");		
	}

}
