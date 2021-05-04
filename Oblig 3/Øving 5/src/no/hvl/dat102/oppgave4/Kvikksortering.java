package no.hvl.dat102.oppgave4;

import java.util.Random;

public class Kvikksortering {

	public static void main(String[] args) {
		// Til bruk ved sortering av store tabellar
		Random tilfeldig = new Random();
		int n = 150;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt();
			}
		}
		// sorter kvar rekke
		long startTid = System.nanoTime();
		for (int i = 0; i < antal; i++) {
			sorter(a[i]); // blir ein eindimensjonal tabell
		}
		long sluttTid = System.nanoTime();

		double tid = ((double) (sluttTid - startTid) / 10000000);
		System.out.println("Tid brukt: " + tid + "ms");
	}

	public static void sorter(Integer[] data) {
		kvikksorter(data, 0, data.length - 1);
	}

	private static void kvikksorter(Integer[] data, int min, int maks) {
		if (min < maks) {
			int indeksPartisjon = partisjon(data, min, maks);
			kvikksorter(data, min, indeksPartisjon - 1);
			kvikksorter(data, indeksPartisjon + 1, maks);
		}
	}

	private static int partisjon(Integer[] data, int min, int maks) {
		Integer partisjonElement;
		int venstre, hoyre;
		int midten = (min + maks) / 2;

		partisjonElement = data[midten];

		bytt(data, midten, min);
		venstre = min;
		hoyre = maks;

		while (venstre < hoyre) {
			while (venstre < hoyre && data[venstre].compareTo(partisjonElement) <= 0) {
				venstre++;
			}

			while (data[hoyre].compareTo(partisjonElement) > 0) {
				hoyre--;
			}

			if (venstre < hoyre) {
				bytt(data, venstre, hoyre);
			}
		}

		bytt(data, min, hoyre);

		return hoyre;
	}

	public static void bytt(Integer[] data, int i1, int i2) {
		Integer temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;
	}
}