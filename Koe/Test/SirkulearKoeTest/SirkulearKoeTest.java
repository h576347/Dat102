package no.hvl.dat102.SirkulearKoeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.SirkulaerKoe.*;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;;

public class SirkulearKoeTest {
	//package 

	/**
	 * Test av SirkulearADT med heltall.
	 * 
	 * @author Ole Olsen
	 */

	    private static final int SIZE = 105;

	    private KoeADT<Integer> sKoe;

	    // Test data
	    private Integer e0 = 1;
	    private Integer e1 = 2;
	    private Integer e2 = 3;
	    private Integer e3 = 4;
	    private Integer e4 = 5;
	   // private Integer e5 = 6;

	    /**
	     * Opprett en stabel for hver test.
	     * 
	     * @throws Exception exception
	     */
	    @Before
	    public final void setup() throws Exception {
	        sKoe = new SirkulaerKoe<Integer>(SIZE);
	    }

	    /**
	     * Tester om en ny stabel er tom.
	     */
	    @Test
	    public final void nyKoeErTom() {
	        assertTrue(sKoe.erTom());
	    }

	    /**
	     * Tester push-pop.
	     */
	    @Test
	    public final void innKoeOgUtKoe() {

	    	sKoe.innKoe(e0);
	    	sKoe.innKoe(e1);
	    	sKoe.innKoe(e2);
	    	sKoe.innKoe(e3);
	    	
	    	try {
	    		assertEquals(e0, sKoe.utKoe());
	    		assertEquals(e1, sKoe.utKoe());
	    		assertEquals(e2, sKoe.utKoe());
	    		assertEquals(e3, sKoe.utKoe());
	    	}catch (EmptyCollectionException e) {
	    			fail("utKoe fungerte ikke som forventet " + e.getMessage());
	    	}
	    }

	    /**
	     * Tester push-pop med like verdier.
	     */
	    @Test
	    public final void innKoeOgUtkoeMedDuplikater() {

	    	sKoe.innKoe(e0);
	    	sKoe.innKoe(e1);
	    	sKoe.innKoe(e1);
	    	sKoe.innKoe(e2);

	    	try {
	        assertEquals(e0, sKoe.utKoe());
	        assertEquals(e1, sKoe.utKoe());
	        assertEquals(e1, sKoe.utKoe());
	        assertEquals(e2, sKoe.utKoe());
	    	}catch (EmptyCollectionException e) {
				fail("Legg til fungerte ikke som forventet " + e.getMessage());
			}
	    }

	    /**
	     * Testing top.
	     */
	    @Test
	    public final void innKoeUtkoeInnKoeInnKoeUtKoeFoerste() {
	    	try {
	    	sKoe.innKoe(e2);
	    	sKoe.utKoe();
	    	sKoe.innKoe(e3);
	    	sKoe.innKoe(e4);
	    	sKoe.utKoe();
	        assertEquals(e4, sKoe.foerste());
	    	} catch (EmptyCollectionException e) {
				fail("innKoe eller foerste fungerte ikke som forventet" + e.getMessage());
			}
	    }

	    /**
	     * Tester om stabel med verdier ikke er tom.
	     */
	    @Test
	    public final void erIkkeTom() {
	    	sKoe.innKoe(e0);
	        assertFalse(sKoe.erTom());
	    }

	    /**
	     * Tester om push-pop p� en tom stabel gir en tom stabel.
	     */
	    @Test
	    public final void innKoeUtKoeErTom() {
	        try {
	    	sKoe.innKoe(e0);
	        sKoe.utKoe();
	        assertTrue(sKoe.erTom());
	        } catch (EmptyCollectionException e) {
				fail("utKoe fungerte ikke som forventet " + e.getMessage());
			}
	    }

	    /**
		 * Trying to pop an element from an empty stabel, should give an underflow
		 * exception.
		 * 
		 * 	 */
		@Test(expected = EmptyCollectionException.class)
		public final void innKoeFraTomUnderflowed() {
			sKoe.utKoe();
		}
	    
	    /**
	     * Tester om stabelen utvider seg riktig. Stabler p� to flere elementer 
	     * enn stabeltabellen har plass til, sjekker om antallet er riktig,
	     * tar ut og sjekker f�rste element, tar ut de i "midten",
	     * tar ut og sjekker det siste elementet og sjekker til slutt
	     * at k�en er tom slik det forventes.
	     */
		
	    @Test
	    public final void utviderKoeSeg() {
	    	sKoe.innKoe(e0);
	        for (int i = 0; i < SIZE; i++) {
	        	sKoe.innKoe(e1);
	        }
	        sKoe.innKoe(e2);
	        assertEquals(SIZE + 2, sKoe.antall());
	        assertEquals(e0, sKoe.utKoe());
	        for (int i = 0; i < SIZE; i++) {
	        	sKoe.utKoe();
	        }
	        assertEquals(e2, sKoe.utKoe());
	        assertTrue(sKoe.erTom());
	    }
	        

}
