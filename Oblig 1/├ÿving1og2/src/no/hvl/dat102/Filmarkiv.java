package no.hvl.dat102;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmTabell; 
	private int antall; 
	
	public Filmarkiv() {
		antall = 0;  
		filmTabell = new Film[10]; 
	
	}
	

	@Override
	public Film[] hentFilmTabell() {
		
		return filmTabell;
	}

	@Override
	public void leggtilFilm(Film nyFilm) {
		
		filmTabell[antall] = nyFilm; 
		antall ++; 
		
	}

	@Override
	public boolean slettFilm(int filmNr) {
		
		boolean slettet = false; 
		int i = 0; 
		
		while(i<antall && !slettet) {
			if(filmTabell[i].getFilmNr() == filmNr) {
				filmTabell[i] = filmTabell[antall-1]; 
				filmTabell[antall-1] = null; 
				antall--; 
				slettet = true; 
			}
			i++;
		}
		
		return slettet;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		
		Film[] delstrengTab = new Film[antall];
		
		int j = 0; 
		
		for(int i = 0; i<antall; i++) {
			if(filmTabell[i].getTittel().contains(delstreng)) {
				delstrengTab[i] = filmTabell[i];
				j++; 
			}
		}
		
		return trimTab(delstrengTab, j);
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		Film[] produsentTab = new Film[antall];
		int j = 0; 
		
		for(int i = 0; i<antall; i++) {
			if(filmTabell[i].getProdusent().contains(delstreng)){ //Sjekker tabellen mot parameteren
				produsentTab[i] = filmTabell[i];  // setter produsent tabellen lik filmtabell[i]
				j++; 
			}
		}
		
		return trimTab(produsentTab, j); 
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		int antSjanger = 0; 
		
		for(int i = 0; i<antall; i++) {
			if(filmTabell[i].getSjanger() == sjanger) { //Sjekker om filmer i tabellen er lik sjanger git
				antSjanger ++;  //Øker verdien til antSjanger.
			}
		}
		
		return antSjanger;
	}

	@Override
	public int antall() {
		
		return antall;
	}
	
	
	private Film[] trimTab(Film[] tab, int n) {
		Film[] filmtab2 = new Film[n];
		int k = 0;
		int i = 0;
		while (i < tab.length) {
			if (tab[i] != null) {
				filmtab2[k] = tab[i];
				k++;
			}
			i++;
		}

		return filmtab2;

	}
}
