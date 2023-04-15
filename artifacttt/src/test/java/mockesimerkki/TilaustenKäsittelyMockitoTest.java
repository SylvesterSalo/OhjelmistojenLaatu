package mockesimerkki;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TilaustenKäsittelyMockitoTest {

	@Mock
	IHinnoittelija hinnoittelijaMock;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testaaKäsittelijäWithMockitoHinnoittelija() {
		// Arrange
		float alkuSaldo = 100.0f;
		float listaHinta = 100.0f;
		float alennus = 20.0f;
		float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
		Asiakas asiakas = new Asiakas(alkuSaldo);
		Tuote tuote = new Tuote("TDD in Action", listaHinta);
		
		// Record
		doNothing().when(hinnoittelijaMock).aloita();
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote)).thenReturn(alennus);
		when(hinnoittelijaMock.setAlennusProsentti(asiakas, alennus)).thenReturn(alennus + 5);
		doNothing().when(hinnoittelijaMock).lopeta();
		
		// Act
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
		käsittelijä.setHinnoittelija(hinnoittelijaMock);
		käsittelijä.käsittele(new Tilaus(asiakas, tuote));
		
		// Assert
		assertEquals(loppuSaldo, asiakas.getSaldo(), 20);
		
		verify(hinnoittelijaMock).aloita();
		verify(hinnoittelijaMock, times(2)).getAlennusProsentti(asiakas, tuote);
		verify(hinnoittelijaMock).setAlennusProsentti(asiakas, alennus);
		verify(hinnoittelijaMock).lopeta();
		
		
	}

}
