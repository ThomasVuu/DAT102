package no.hvl.dat102;

import java.util.Scanner;
import no.hvl.dat102.ADT.FilmarkivADT;

public class Tekstgrensesnitt {

// lese opplysningene om FILM fra tastatur
	public Film lesFilm() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Nummer på film?");
		int filmNr = Integer.parseInt(scan.nextLine());
		
		System.out.println("Navn på produsent?");
		String produsent = scan.nextLine();
		
		System.out.println("Tittel på filmen? ");
		String tittel = scan.nextLine();
		
		System.out.println("Hvilket år ble filmen gitt ut? ");
		int aar = Integer.parseInt(scan.nextLine());
		
		System.out.println("Sjanger på filmen? ");
		String tempSjanger = scan.nextLine(); 
		
		Sjanger sjanger = Sjanger.finnSjanger(tempSjanger);
		
		System.out.println("Hvilket filmselskap ? ");
		String filmselskap = scan.nextLine();
		
		
		return new Film(filmNr, produsent, tittel, aar, sjanger, filmselskap);
		
	}
	
//vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
	
		System.out.println("Filmnr: " + film.getFilmNr() + "\n" 
				+ "Produsent: " + film.getProdusent() + "\n"
				+ "Tittel: " + film.getTittel() + "\n"
				+ "Utgivelsesår: " + film.getAar() + "\n" 
				+ "Sjanger: " + film.getSjanger() + "\n" 
				+ "Filmselskap: " + film.getFilmselskap());
		
	}
	
//Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengTittel(FilmarkivADT film, String delstreng) {
		
		Film[] tittel = film.sokTittel(delstreng);
		
		for(Film i : tittel) {
			visFilm(i); 
		}
	}
	
//Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT film, String delstreng) {
		
		Film[] produsent = film.sokProdusent(delstreng);
		
		for(Film i : produsent) {
			visFilm(i); 
		}
		
		
	}
	
//Skriver ut en enkel statistikk som inneholder antall Filmer totalt
//og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT film) {
		
		System.out.println("Antall filmer totalt: " + film.antall());
		
		for(Sjanger sj : Sjanger.values()) {
			System.out.println(sj.name() + ": " + film.antallSjanger(sj));
		}
	}
		
		 public static void operasjoner() {
			 System.out.println("Skriv tallet for operasjonen du ønsker å utføre: " +"\n"
						+ "1: Legg inn en ny film" +"\n"
						+ "2: Slette en film" + "\n"
						+ "3: Hent tittel på film med delstreng" + "\n"
						+ "4: Hente produsenter til filmen med produsentnavn" + "\n"
						+ "5: Hente antall filmer" + "\n"
						+ "6: Skriv ut statistikk" + "\n"
						+ "0: Lagre og avslutt");
		 }
}
