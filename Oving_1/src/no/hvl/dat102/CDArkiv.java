package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;
import no.hvl.dat102.Sjanger;

import java.util.InputMismatchException;


public class CDArkiv implements CDarkivADT{
	private CD[] cdTabell;
	private int antall;
	
	
	public CDArkiv(int antall) {
		this.antall = 0;
		this.cdTabell = new CD[antall];
	}
	
	public CDArkiv(){
		this(0);
		cdTabell = new CD[100];
	}
	
	@Override
	public CD[] hentCdTabell() {
		return cdTabell;
	}
	
	@Override
	public void leggTilCd(CD nyCd) {
		
		if (antall == cdTabell.length){
			utvidKapasitet();
		}
			cdTabell[antall] = nyCd;
			antall++;
	}
		
	
	private void utvidKapasitet() {
	
		CD[] hTab = new CD[(int)Math.ceil(1.1 * cdTabell.length)];
		
		for (int i = 0; i < cdTabell.length; i++){
			hTab[i] = cdTabell[i];
			trimTab(hTab, i);
			
		}
		cdTabell = hTab;
	}
	
	
	
	private CD[] trimTab(CD[] tab, int n) {// n er antall elementer
		CD[] cdtab2= new CD[n];
		int i= 0;while(i< n) {
			cdtab2[i] = tab[i];
			i++;
		}//while
		return cdtab2;
	}
	
	
	@Override
	public boolean slettCd(int cdNr) {
		
		boolean slettet = false;		
		int i = 0;
		
		try {
			
		while(!slettet || i < antall) {
			if(cdNr == cdTabell[i].getCdNr()) {
				cdTabell[i] = cdTabell[antall -1];
				cdTabell[antall -1] = null;
				antall--;

				System.out.println("CD " + cdNr + " slettet"+ "\n");
				slettet = true;
				
			} else {
				i++;
			}
				
		}
		if(!slettet) {
			System.out.println("CD-en finnes ikke" + "\n");
			
		}
		} catch(InputMismatchException a) {
			System.out.println("Obs, her gikk noe galt! Avslutt og prøv på nytt!");
			
			}
		return slettet;
	}
	
	@Override
	public CD[] sokTittel(String delstreng) {
		
		CD[] hTab = new CD[antall];
		int y = 0;
		
		
		for(int i =  0; i < antall; i++) {
			if(cdTabell[i].getTittel().contains(delstreng)) {
				hTab[y] = cdTabell[i];
				y++;
				}
			} 
			
		return hTab;
		
	}
	
	@Override
	public CD[] sokArtist(String delstreng) {
		
		CD[] hTab = new CD[antall];
		int y = 0;
		
		for(int i =  0; i < antall; i++) {
			if(cdTabell[i].getArtist().contains(delstreng)) {
				hTab[y] = cdTabell[i];
				y++;
			}
		}
		
		return hTab;
	}
	
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		int antallSjanger = 0;
		for(int i= 0; i < antall; i++) {
			if(cdTabell[i].getSjanger() == sjanger) {
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
