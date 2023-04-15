package mockesimerkki;

public interface IHinnoittelija {
	public abstract float getAlennusProsentti(Asiakas asiakas, Tuote tuote);
	public abstract void aloita();
	public abstract float setAlennusProsentti(Asiakas asiakas, float alennuksenMäärä);
	public abstract void lopeta();
	
}
