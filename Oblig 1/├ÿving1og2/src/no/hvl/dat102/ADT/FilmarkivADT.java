package no.hvl.dat102.ADT;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {

	/**
	 * 
	 * @return film tabell
	 */

//Returnere en tabell av Filmer
	Film[] hentFilmTabell(); 
	
	/**
	 * 
	 * @param nyFilm
	 */
	
//Legger til en ny Film
	void leggtilFilm(Film nyFilm);
	
	/**
	 * 
	 * @param filmNr
	 * @return boolean
	 */
	
	
//Slette en Film hvis den fins
	boolean slettFilm(int filmNr); 
	
	/**
	 * 
	 * @param delstreng
	 * @return Film[]
	 */
	
//Søker og henter Filmer med en gitt delstreng
	
	Film[] sokTittel(String delstreng); 
	
	/**
	 * 
	 * @param delstreng
	 * @return Film[]
	 */
	
//Søker og henter produsenter med en gitt delstreng
	Film[] sokProdusent(String delstreng); 
	
	/**
	 * 
	 * @param sjanger
	 * @return int
	 */
	
//Henter antall Filmer for en gitt sjanger
	int antallSjanger(Sjanger sjanger); 
	/**
	 * 
	 * @return int
	 */

//Returnerer antall Filmer
	int antall(); 



}//interface
