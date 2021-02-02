package no.hvl.dat102.SirkulaerKoe;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T>{
	private  static final int STD = 100;
	private int front, bak, antall;
	private T[] koe; 
	
	/***************************************************
	 * Oppretter en tom kø med standard kapasitet.  
	 * ***************************************************/
	
	public SirkulaerKoe(){
		this(STD);
		}
	
	/***************************************************
	 * Oppretter en tom kø med en spesifisert kapasitet.  
	 * ***************************************************/
	public SirkulaerKoe(int startKapasitet) {
		koe = (T[])(new Object[startKapasitet]) ;
		front =  0;
		bak = 0;
		antall= 0;
		}
	
	/***************************************************
	 * Legger til et element i køen, utvider hvis nødvendig. 
	 * ***************************************************/
	public void innKoe(T element)  {
		if (antall() == koe.length){ 
			utvid();
		}    koe[bak] = element;
		bak = (bak+1) % koe.length;
		antall++;
		}  
	
	/***************************************************
	 * Fjerner og returnerer elementet foran i køen. 
	 *  ***************************************************/
	public T utKoe() {
		if(erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = koe[front];
		front = (front + 1) % koe.length;
		antall--;
		return resultat;
		}
	
	/*************************************************
	 * Oppretter en ny større tabell for å lagre elementene. 
	 * *************************************************/
	private void utvid(){ 
		T[] hjelpetabell = (T[])(new Object[koe.length*2]);
		for(int soek= 0; soek < antall; soek++){
			hjelpetabell[soek] = koe[front];
		front = (front+1) % koe.length; 
		} 
		front = 0;
		bak   = antall;
		koe= hjelpetabell;
		}// De andre metodene som for vanlig tabellimplementasjon
	
	public boolean erTom() {
		return (antall == 0);
	}

	public int antall() {
		return antall;
	}
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("k�");

		T resultat = koe[front];
		return resultat;
	}
}
