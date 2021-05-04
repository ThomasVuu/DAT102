package no.hvl.dat102;
import no.hvl.dat102.ADT.*;

public class Filmarkiv2 implements FilmarkivADT{

	private int antall; 
	private LinearNode<Film> start; 
	
	public Filmarkiv2(){
		
		start = null; 
		antall = 0; 
		
	}
	
	
	@Override
	public Film[] hentFilmTabell() {

		LinearNode<Film> denne = start; 
		Film[] tab = new Film[antall];
		
		for(int i = 0; i<antall; i++) {
			tab[i] = denne.getElement(); 
			denne = denne.getNeste(); 
		}
		
		return tab; 
	}
	

	@Override
	public void leggtilFilm(Film nyFilm) {
		
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm); 
		nyNode.setNeste(start);
		start = nyNode; 
		antall++; 
		
	}

	@Override
	public boolean slettFilm(int filmNr) {
		
		LinearNode<Film> forrige = null;
		LinearNode<Film> p = start; 
		boolean slettet = false; 
		
		if((p != null) && (p.getElement().getFilmNr() == filmNr)){
			start = p.getNeste(); 
			antall --; 
			slettet = true; 
		}else if(p!=null){
			while(p != null && p.getElement().getFilmNr() != filmNr){
				forrige = p; 
				p = p.getNeste(); 
			}
			forrige.setNeste(p.getNeste());
			antall--; 
			slettet = true; 
		}
		return slettet;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		
		LinearNode<Film> denne = start; 
		Film[] filmtabell = new Film[antall];
		
		
		int j = 0; 
		for(int i = 0; i<antall; i++) {
			if(denne.getElement().getTittel().toLowerCase().contains(delstreng)) {
				filmtabell[j] = denne.getElement();
				j++; 
				
			}
			denne = denne.getNeste();
		}
		return trimTab(filmtabell, j);
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		
		
		LinearNode<Film> denne = start; 
		Film[] filmtabell = new Film[antall];
		
		
		int j = 0; 
		for(int i = 0; i<antall; i++) {
			if(denne.getElement().getProdusent().toLowerCase().contains(delstreng)) {
				filmtabell[j] = denne.getElement();
				j++; 
				
			}
			denne = denne.getNeste();
		}
		
		return trimTab(filmtabell, j);
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		int ant = 0; 
		LinearNode<Film> denne = start; 
		
		for(int i = 0; i<antall; i++) {
			if(denne.getElement().getSjanger().equals(sjanger)) {
				ant++; 
			}
			denne = denne.getNeste(); 
		}
		
		return ant;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//Hjelpemetode
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
