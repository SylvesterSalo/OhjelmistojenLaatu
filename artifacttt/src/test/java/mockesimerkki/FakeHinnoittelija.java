package mockesimerkki;

public class FakeHinnoittelija implements IHinnoittelija {

	private float alennus;

	public FakeHinnoittelija(float alennus) {
		this.alennus = alennus;
	}

	public float getAlennusProsentti(Asiakas asiakas, Tuote tuote) {
		return alennus;
	}

	@Override
	public void aloita() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float setAlennusProsentti(Asiakas asiakas, float määrä) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void lopeta() {
		// TODO Auto-generated method stub
		
	}

}
