package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class TabellKoe<T> implements KoeADT<T> {

	private final static int STDK = 100; 
	private int bakerste; 
	private T[] koe; 
	
	public TabellKoe() {
		this(STDK); 
		
	}
	
	public TabellKoe(int startKapasitet) {
		koe = ((T[]) (new Object[startKapasitet]));
		bakerste = 0; 
	}
	
	@Override
	public void innKoe(T element) {
		
		if(antall() == koe.length) {
			utvid(); 
		}
		koe[bakerste] = element; 
		bakerste = bakerste + 1; 
	}

	@Override
	public T utKoe() {

		if(erTom()) {
			throw new EmptyCollectionException("koe");
		}
		
		T resultat = koe[0];
		bakerste--; 
		
		for(int flytt = 0; flytt<bakerste; flytt++) {
			koe[flytt] = koe[flytt + 1]; 
		}
		koe[bakerste] = null; 
		
		return resultat;
	}

	@Override
	public T foerste() {
	
		if(erTom()) {
			throw new  EmptyCollectionException("koe");
		}
		
		T resultat = koe[0];
		return resultat;
	}

	@Override
	public boolean erTom() {

		return(bakerste == 0);
	}

	@Override
	public int antall() {

		return bakerste; 
	}
	
	private void utvid() {
	       T[] hjelpetabell = (T[])(new Object[koe.length*2]);

	      for (int soek =0; soek < koe.length; soek++){
	         hjelpetabell[soek] = koe[soek];
		  }

	       koe = hjelpetabell;
	   }

	
	
}
