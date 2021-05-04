package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filma;
	public static final Scanner IN = new Scanner(System.in);
	public static final String SKILLE = "-------------------------------------------";

	 
	 
	 public Meny(FilmarkivADT filma){
		 tekstgr = new Tekstgrensesnitt();
		 this.filma = filma;
		 
	 }
	 
	 public void start(){
	
			boolean gyldig = false;
			String filnavn = " ";

			do {
				System.out.println("Vil du jobbe med et eksisterende arkiv? Ja/Nei");
				String svar = IN.nextLine();
				System.out.println(SKILLE);

				if (svar.equals("ja")) {
					System.out.println("Skriv inn filnavnet du vil jobbe med: ");
					filnavn = IN.nextLine();
					System.out.println(SKILLE);
					filma = Fil.lesFraFil(filnavn);
					gyldig = true;

				} else if (svar.equals("nei")) {
					System.out.println("Skriv inn navnet på den nye filen: ");
					filnavn = IN.nextLine();
					System.out.println(SKILLE);
					gyldig = true;
				} else {
					System.out.println(svar + " er et ugyldig svar ");
				}
			} while (!gyldig);

			int input = 1;

			do {
				Tekstgrensesnitt.operasjoner();

				input = Integer.parseInt(IN.nextLine());
				switch (input) {
				case 1:
					filma.leggtilFilm(tekstgr.lesFilm());
					break;
				case 2:
					System.out.println("Hvilken film vil du slette? Skriv film-nummer");
					int valg1 = Integer.parseInt(IN.nextLine());
					filma.slettFilm(valg1);
					break;
				case 3:
					System.out.println("Skriv delstrengen på tittel du vil hente film med");
					String ds = IN.nextLine();
					tekstgr.skrivUtFilmDelstrengTittel(filma, ds);
					break;
				case 4:
					System.out.println("Skriv deler av navnet på artisten du vil hente CD fra");
					String ds2 = IN.nextLine();
					tekstgr.skrivUtFilmProdusent(filma, ds2);
					break;
				case 5:
					System.out.println("Antall filmer: " + filma.antall());
					break;
				case 6:
					tekstgr.skrivUtStatistikk(filma);
					break;

				}
			} while (input != 0);

			Fil.skrivTilFil(filma, filnavn);
			System.out.println("Filen " + filnavn + ".txt ble lagret i mappen" + System.getProperty("user.dir"));
			System.out.println("Programmet er avsluttet");
			IN.close();
		 
	 }

}
