package no.hvl.dat102;

import java.util.InputMismatchException;
import java.util.Scanner;
import no.hvl.dat102.adt.*;


public class tekstGrensesnitt {

	// lese opplysningene om en CD fra tastatur
	public CD lesCD(){
		
		Scanner tastatur = new Scanner(System.in);
		
		CD plate = null;
		
		
		try {
		System.out.println("Skriv inn CD-nummer:\t" ); 
		int CDnr = tastatur.nextInt();
		tastatur.nextLine();
		
		System.out.println("Skriv inn artistnavn:\t");
		String navn = tastatur.nextLine();
		
		System.out.println("Skriv inn CD-Tittel:\t");
		String tittel = tastatur.nextLine();
		
		System.out.println("Skriv inn lanseringsår:\t");
		int lanseringsaar = tastatur.nextInt();
		tastatur.nextLine();
				
		System.out.println("Skriv inn sjanger:\t");
		Sjanger sjanger = Sjanger.finnSjanger(tastatur.nextLine());
		
		System.out.println("Skriv inn plateselskap:\t");
		String selskap = tastatur.nextLine();
		
		plate = new CD(CDnr, navn, tittel, lanseringsaar, sjanger, selskap);
		
		} catch(InputMismatchException a) {
			System.out.println("Ugyldig input");
		
		}
		return plate;
		
	}
	
	
	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd){
		
		System.out.println(cd.getCdNr() + "\n"
							+ cd.getArtist() + "\n"
							+ cd.getTittel() + "\n"
							+ cd.getAar() + "\n"
							+ cd.getSjanger() + "\n"
							+ cd.getPlateselskap() + "\n");
		
	}
	
	
	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng){
		
		CD[] tab = cda.sokTittel(delstreng);
		try {
		for (CD cd : tab) {
			visCD(cd);
		}
		} catch (NullPointerException e) {
			System.out.println("Finner ikke tittel \n");
		}
		
	}
	
	
	
	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		
		CD[] tab = cda.sokArtist(delstreng);
		try {
		for (CD cd : tab) {
			visCD(cd);	
		}
		} catch (NullPointerException e) {
			System.out.println("Finner ikke Artist, sjekk skrivemåte\n");
		
		}
	}
	
	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(CDarkivADT cda){
		
		System.out.println("Antall CD-er: " + cda.antall());
		
		Sjanger[] sj = Sjanger.values();
		int lengde = Sjanger.values().length;
		int[] telleSjanger = new int[lengde];
		
		for (int i = 0; i < lengde; i++) {
			telleSjanger[i] = cda.antallSjanger(sj[i]);
		}
		
		System.out.println("Rock: " + telleSjanger[0] + "\n"+ 
							"POP: " + telleSjanger[1] + "\n" +
							"Opera: " + telleSjanger[2] + "\n" +
							"Klassisk: " + telleSjanger[3]+"\n");
		
	}
	
	
	public void skrivUtCdtabell(CDarkivADT cda) {
		
		try{
	
			CD[] tab = cda.hentCdTabell();
			
		for(int i = 0; i < cda.antall(); i++) {
		System.out.println(
				"CDNr\t\t: " + tab[i].getCdNr() + "\n"+
				"Artist/gruppe\t: " + tab[i].getArtist() + "\n" +
				"Tittel\t\t: " + tab[i].getTittel()+ "\n" +
				"Lanseringsår\t: " + tab[i].getAar() + "\n"+
				"Sjanger\t\t: " + tab[i].getSjanger() + "\n" +
				"Plateselskap\t: " + tab[i].getPlateselskap()+ "\n\n");
	}
		
	}catch(NullPointerException e) {
		System.out.println("Det eksisterer ingen cd-er");
	}
	}
	
	
	
	//Oversikt over mulige handlinger
	public void oversiktTekst() {
		
	String oversikt =
			"---------------------------\n"+
			"Handlingsmuligheter: \n\n" +
			"1 - legg til ny CD\n" +
			"2 - hent CD-tabell\n" +
			"3 - Slett CD\n" +
			"4 - Finn tittel og skriv ut CD-info\n"+
			"5 - Finn artist/gruppe og skriv ut CD-info\n" +
			"6 - Skriv ut statistikk\n"+
			"7 - Antall CD\n"+
			"8 - Oversikt over muligheter\n" +
			"0 - Avslutt og lagre\n"+
			"---------------------------\n";
		
			System.out.println(oversikt);
	}	
	
	
	public String videreHandlingTekst(int valg) {
		
		String tekst = ""; 
		
		if(valg != 8 && valg != 0) {
			tekst = "-------------------------------------------\n" + 
					"Trykk ett tall for en ny handling\n" +
					"trykk 8 for å få opp oversikt\n" + 
					"eller trykk 0 for å lager og avslutte\n"+
					"-------------------------------------------\n";
		}
		else if(valg == 8) {
			tekst = "---------------------------------------\n"+
					"Trykk ett tall for å gjøre en handling\n"+
					"---------------------------------------\n";
		}
		return tekst;
	}

	
}