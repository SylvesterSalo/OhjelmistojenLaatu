package kivipaperisakset;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PelaajaTest {

	Pelaaja p1 = new Pelaaja();
	
	@Test
	@DisplayName("uusiValinta(): toimiiko uuden valinnan luonti oikein")
	void testUusiValinta() {
		p1.uusiValinta();
		assertTrue((p1.getValinta().equals("kivi") || p1.getValinta().equals("paperi") || p1.getValinta().equals("sakset")), "Pelaajan uuden valinnan jälkeen valinnan tulisi palauttaa kivi, paperi tai sakset");
		
	}

}
