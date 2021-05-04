package no.hvl.dat102.adt;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import no.hvl.dat102.sirkulaer.*;

import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeADTTest {
		protected static final int SIZE = 10;
	
	// Referanse til koe
		private KoeADT<Integer> koe;

		// Testdata
		private Integer e0 = 1;
		private Integer e1 = 2;
		private Integer e2 = 3;
		private Integer e3 = 4;
		private Integer e4 = 5;

		@Before
		public final void setup() {
			koe = new SirkulaerKoe<Integer>(SIZE);
		}

		@Test
		public final void nyKoeErTom() {
			assertTrue(koe.erTom());
		}

		@Test
		public final void innKoeOgUtKoe() {

			koe.innKoe(e0);
			koe.innKoe(e1);
			koe.innKoe(e2);
			koe.innKoe(e3);

			try {
				assertEquals(e0, koe.utKoe());
				assertEquals(e1, koe.utKoe());
				assertEquals(e2, koe.utKoe());
				assertEquals(e3, koe.utKoe());
			} catch (EmptyCollectionException e) {
				fail("utkoe feilet uventet " + e.getMessage());
			}
		}

		@Test
		public final void innKoeOgUtKoeMedDuplikater() {

			koe.innKoe(e0);
			koe.innKoe(e1);
			koe.innKoe(e1);
			koe.innKoe(e2);

			try {
				assertEquals(e0, koe.utKoe());
				assertEquals(e1, koe.utKoe());
				assertEquals(e1, koe.utKoe());
				assertEquals(e2, koe.utKoe());
			} catch (EmptyCollectionException e) {
				fail("utkoe feilet uventet " + e.getMessage());
			}
		}

		@Test
		public final void innKoeUtKoeInnKoeInnKoeUtKoeForste() {
			try {
				koe.innKoe(e2);
				koe.utKoe();
				koe.innKoe(e3);
				koe.innKoe(e4);
				koe.utKoe();
				assertEquals(e4, koe.foerste());

			} catch (EmptyCollectionException e) {
				fail("utkoe eller foerste feilet uventet " + e.getMessage());
			}
		}

		@Test
		public final void erIkkeTom() {
			koe.innKoe(e0);
			koe.innKoe(e1);
			assertFalse(koe.erTom());
		}

		@Test
		public final void innKoeUtKoeErTom() {
			try {
				koe.innKoe(e0);
				koe.utKoe();
				assertTrue(koe.erTom());

			} catch (EmptyCollectionException e) {
				fail("innkoe eller utkoe feilet uventet " + e.getMessage());
			}
		}

		@Test
		public final void stor() {
			koe.innKoe(e0);
			koe.innKoe(e1);
			koe.innKoe(e2);
			assertEquals(3, koe.antall());
		}

		@Test(expected = EmptyCollectionException.class)
		public final void popFromEmptyIsUnderflowed()
				throws EmptyCollectionException {
			koe.utKoe();
		}
		
		@Test
	    public final void utviderKoeSeg() {
	        koe.innKoe(e1);
	        for (int i = 0; i < SIZE; i++) {
	            koe.innKoe(e0);
	        }
	        koe.innKoe(e2);
	        assertEquals(SIZE + 2, koe.antall());
	        assertEquals(e1, koe.utKoe());
	        for (int i = 0; i < SIZE; i++) {
	            koe.utKoe();
	        }
	        assertEquals(e2, koe.utKoe());
	        assertTrue(koe.erTom());
	    }
}