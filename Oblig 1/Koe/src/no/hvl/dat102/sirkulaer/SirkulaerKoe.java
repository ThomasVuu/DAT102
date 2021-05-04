package no.hvl.dat102.sirkulaer;


import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {
	private static final int STDK = 100;
	private int foerste, bakerste, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		koe = (T[]) (new Object[startKapasitet]);
		foerste = bakerste = 0;
		antall = 0;
	}

	@Override
	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}

		koe[bakerste] = element;
		bakerste = (bakerste + 1) % koe.length;
		antall++;
	}

	@Override
	public T utKoe() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}

		T resultat = koe[foerste];
		koe[foerste] = null;
		foerste = (foerste + 1) % koe.length;
		antall--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}
		
		T resultat = koe[foerste];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall() == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int soek = 0; soek < antall; soek++) {
			hjelpetabell[soek] = koe[foerste];
			foerste = (foerste + 1) % koe.length;
		}

		foerste = 0;
		bakerste = antall;
		koe = hjelpetabell;
	}
	
}