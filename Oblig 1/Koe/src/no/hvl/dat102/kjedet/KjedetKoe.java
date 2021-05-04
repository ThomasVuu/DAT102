package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class KjedetKoe<T> implements KoeADT<T> {
	
	LinearNode<T> foerste; 
	LinearNode<T> bakerste; 
	private int antall; 

	
	public KjedetKoe() {
		foerste = null; 
		bakerste = null; 
		antall = 0; 
	}
	
	@Override
	public void innKoe(T element) {
		
		LinearNode<T> nyNode = new LinearNode<T>(element); 
		
		if(erTom()) {
			foerste = nyNode; 
			}else {
			bakerste.setNeste(nyNode);
		}
		bakerste = nyNode; 
		antall++; 
	}

	@Override
	public T utKoe() {
		
		if(erTom()) {
			throw new EmptyCollectionException("koe"); 
		}
		T resultat = foerste.getElement(); 
		foerste = foerste.getNeste(); 
		antall--; 
		
		if(erTom()) {
			bakerste = null; 
		}
		
		return resultat;
	}

	@Override
	public T foerste() {
		
		if(erTom()) {
			throw new EmptyCollectionException("koe"); 
		}
		T resultat = foerste.getElement(); 
		
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
	

}
