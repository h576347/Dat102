package no.hvl.dat102;

import no.hvl.dat102.LinearNode.*;

public class UordnetKjedetListe<T> implements UordnetKjedetListeADT<T> {

	private int antall;
	private LinearNode<T> foerste, siste;

	public UordnetKjedetListe() {
		antall = 0;
		foerste = null;
		siste = null;

	}

	// a
	public int antallLike(T el) {
		int like = 0;

		LinearNode<T> denne = foerste;
		LinearNode<T> forrige = null;

		while (denne != null) {
			if (denne.getElement().equals(el)) {
				like++;
			} else {
				forrige = denne;
				denne = denne.getNeste();
			}

		}

		return like;
	}

	// b
	public T minste() {

		LinearNode<T> denne = foerste;
		LinearNode<T> forrige = null;
		T elem = null;

		if (antall == 1) {
			elem = foerste.getElement();

		} else {
			while (denne != null) {
				elem = denne.getElement();

				forrige = denne;
				denne = denne.getNeste();

				if (elem.compareTo(denne.getElement()) > 0) {
					elem = denne.getElement();
				}
				denne = denne.getNeste();

			}
		}
		return elem;
	}

	// c
	public boolean inneholder(T element) {
		return inneholderRek(foerste, element);
	}

	private boolean inneholderRek(LinearNode<T> denne, T element) {
		//Fyll ut
	
		boolean eksisterer = false;
		
		while(denne != null && !eksisterer) {
				if(denne.getElement().equals(element)) {
					eksisterer = true;
				} else {
					denne = denne.getNeste();
				}
			}
		return eksisterer;
}
	
	
}
