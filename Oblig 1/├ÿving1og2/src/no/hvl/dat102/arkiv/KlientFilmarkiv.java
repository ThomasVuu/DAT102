package no.hvl.dat102.arkiv;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Meny;
import no.hvl.dat102.ADT.FilmarkivADT;

public class KlientFilmarkiv {

	public static void main(String[] args) {
	
		
		//Meny
		FilmarkivADT filmer = new Filmarkiv();
		
		Meny meny = new Meny(filmer); 
		meny.start();
	}

}
