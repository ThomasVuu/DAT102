package no.hvl.dat102;

public class Film {

	private int filmNr;
	private String produsent; 
	private String tittel; 
	private int aar; 
	Sjanger sjanger;
	private String filmselskap; 
	
	
	public Film() {
		this(0,"", "", 0, null,"");
		
	}
	
	public Film(int filmNr, String produsent, String tittel, int aar, Sjanger sjanger, String filmselskap) {
		
		this.filmNr = filmNr; 
		this.produsent = produsent; 
		this.tittel = tittel; 
		this.aar = aar; 
		this.sjanger = sjanger; 
		this.filmselskap = filmselskap; 
	}

	public int getFilmNr() {
		return filmNr;
	}

	public String getProdusent() {
		return produsent;
	}


	public String getTittel() {
		return tittel;
	}


	public int getAar() {
		return aar;
	}


	public Sjanger getSjanger() {
		return sjanger;
	}


	public String getFilmselskap() {
		return filmselskap;
	}	
	
}
