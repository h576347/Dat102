package no.hvl.dat102;


import no.hvl.dat102.adt.*;


public class CDarkiv2 implements CDarkivADT {
	private int antall;
	private LinearNode<CD> start;
	/*  Klassen skal ha de samme operasjoner som for CDarkiv iøving 1, 
	 * men pass på at implementeringenav alle metoder blir tilpasset den nyestrukturen. */
	
	public CDarkiv2(int antall) {
		this.antall = antall;
		start = null;
	}
	
	public CDarkiv2() {
		this(0);
		start = null;
	}

	@Override
	public CD[] hentCdTabell() {
		
		LinearNode<CD> denne = start;
		
		CD[] hTab = new CD[antall];
		
		if(denne != null) {
			for(int i = 0; i < antall; i++) {
			hTab[i] = denne.getElement();
			}
		}
		return hTab;
	}
	
	@Override
	public void leggTilCd(CD nyCd) {
		
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd);

		nyNode.setNeste(start);
		start = nyNode;
		antall++;
		
	}
	
	@Override
	public boolean slettCd(int cdNr) {
		
		boolean slettet = false;		
		
		LinearNode<CD> denne = start;
		LinearNode<CD> forrige = null;
		
		if(denne == null) {
			slettet = false;
		} else if(denne != null && denne.getElement().getCdNr() == cdNr) {
			start = denne.getNeste();
			antall--;
			slettet = true;
		}else {
				while(denne.getNeste().getElement() != null){
					if(denne.getNeste().getElement().getCdNr() == cdNr){
						forrige = denne.getNeste();
						denne.setNeste(forrige.getNeste());
						antall--;
						slettet = true;
					}else {
						denne = denne.getNeste();
					}
				}
				
			
			} return slettet;
		}
		
	
	@Override
	public CD[] sokTittel(String delstreng) {
		
		LinearNode<CD> denne = start;
		CD[] hjelpetabell = new CD[antall];
		int y = 0;
		
		
		for(int i =  0; i < antall; i++) {
			if(denne.getElement().getTittel().contains(delstreng)) {
				hjelpetabell[y] = denne.getElement();
				y++;
				}
			else {
				denne = denne.getNeste();
				}
			} 
		return hjelpetabell;
		
	}
	
	@Override
	public CD[] sokArtist(String delstreng) {
		
		LinearNode<CD> denne = start;
		CD[] hjelpetabell = new CD[antall];
		int y = 0;
		
		for(int i =  0; i < antall; i++) {
			if(denne.getElement().getArtist().contains(delstreng)) {
				hjelpetabell[y] = denne.getElement();
				y++;
			} else {
				denne = denne.getNeste();
			}
		}
		
		return hjelpetabell;
	}
	
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		LinearNode<CD> denne = start;
		
		int antallSjanger = 0;
		for(int i= 0; i < antall; i++) {
			if(denne.getElement().getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		
		return antallSjanger;	
	}
	
	@Override
	public int antall() {
		return antall;
	}
	
}

