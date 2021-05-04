package no.hvl.dat102.klient;

import java.util.*;

import javax.swing.JOptionPane;

import no.hvl.dat102.KjedetBSTre;

public class KlientRandom {

	public static void main(String[] args) {
		int antallNoder = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall noder: "));
		int storste = 0, minste = antallNoder, sumHoyde = 0;
		int minHoyde = (int) (Math.log(antallNoder) / Math.log(2));
		int maksHoyde = antallNoder-1;
		Random terning = new Random();
		
		for (int i = 0; i < 100; i++) {
			KjedetBSTre<Integer> tre = new KjedetBSTre<Integer>();
			
			for (int j = 0; j < antallNoder; j++) {
				tre.leggTil(terning.nextInt());
			}
			
			if (storste < tre.Hoyde()) {
				storste = tre.Hoyde();
			}
			
			if (minste > tre.Hoyde()) {
				minste = tre.Hoyde();
			}
			sumHoyde += tre.Hoyde();
		}
		
		double snitt = sumHoyde/100.0;

		System.out.println("Antall noder: " + antallNoder);
		System.out.println("Den minimale teoretiske høyden: " + minHoyde);
		System.out.println("Den maksimale teoretiske høyden: " + maksHoyde);
		System.out.println("Minste høyde i løpet av kjøringene: " + minste);
		System.out.println("Største høyde i løpet av kjøringene: " + storste);
		System.out.println("Gjennomsnittshøyden til trærne: " + snitt);
	}
}
