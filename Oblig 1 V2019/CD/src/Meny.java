package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Meny {
	private tekstGrensesnitt tekstgr;
	private CDarkivADT cda;
	private String filnavn;
	
	public Meny(CDarkivADT cda){
		tekstgr = new tekstGrensesnitt();
		this.cda = cda;
		filnavn = "";

	}
	
	public void start() {
		
		Scanner tast = new Scanner(System.in);
		
		String innSkrift = "";
		int cdNr = 0;
		int valg = 8;
		
		
		try {
			
		int svar = foersteValg();
		filnavn = nyttEllerGammeltArkiv(svar);
		tekstgr.oversiktTekst();
		
		
		while(valg != 0) {
				
			valg = tast.nextInt();
			tast.nextLine();
		
			if(valg == 3) {
				System.out.println("Skriv inn CDnr: ");
				cdNr = tast.nextInt();
				tast.nextLine();
				
			}else {
				innSkrift = skrivInnInfo(valg);
			}
			
			
			hendelsesLoep(valg, innSkrift, cdNr);
			System.out.println(tekstgr.videreHandlingTekst(valg));
			
		}
		
		tast.close();
		
		} catch(InputMismatchException a) {
			System.out.println("Obs, her gikk noe galt! Avslutt og prøv på nytt!");
			
			}
	}
	
	
	
	//Spoersmål om opprettelse av arkiv eller redigere ett eksisterende ett.
	public int foersteValg() {
		
		Scanner tast = new Scanner(System.in);
		
		int svar = 0;
		int antValg = 0;
		boolean feil = false;
		
		while(!feil && antValg <= 4) {
			System.out.println("Trykk 1 for å opprette et nytt arkiv, og 2 for å redigere ett eksisterende arkiv");
		
			svar = tast.nextInt();
			tast.nextLine();
		
			antValg++;
			
			if(svar == 1 || svar == 2 ) {
			feil = true;
				}
			else {
				int forsok = 3 - antValg;
				System.out.println("Obs, prøv igjen! Du har: " + forsok + " forsøk igjen");
				}
			
			}
		return svar;
	}
	
	
	
	//Spørsmål om å redigere allerede eksisterende arkiv eller opprette ett nytt arkiv
		public String nyttEllerGammeltArkiv(int svar) {
			
			Scanner tast = new Scanner(System.in);
			
			if(svar == 1) {
				cda = new CDArkiv();
				System.out.println("Nytt Arkiv er opprettet\n"
									+ "Skriv inn navn på Arkivet:\n");
				
				filnavn = tast.nextLine();
				
				}
			
			else if(svar == 2) {
				System.out.println("Skriv inn arkivnavnet: \n");
				filnavn = tast.nextLine();
				cda = Fil.lesFraFil(filnavn);
				}
			
			return filnavn;
		}
		
		
		
		//Oversikt over tekst-spørsmål etter å ha valgt hendelse
		public String skrivInnInfo(int valg) {
			
			Scanner tast = new Scanner(System.in);
			String innSkrift = "";
			
			if(valg == 4) {
				System.out.println("Skriv inn tittel: \n");
				innSkrift = tast.nextLine();
			}
			
			if(valg == 5) {
				System.out.println("Skriv inn artist/gruppenavn: \n");
				innSkrift = tast.nextLine();
			}
			return innSkrift;
		
		}
	
	//Oversikt over switch-setningen
	public void hendelsesLoep(int valg, String innSkrift, int cdNr) {
		
		switch(valg) {
		
		case 1: 
			cda.leggTilCd(tekstgr.lesCD());
			break;
		
		case 2:
			tekstgr.skrivUtCdtabell(cda);
			break;
			
		case 3:
			cda.slettCd(cdNr);
			break;
			
		case 4:
			tekstgr.skrivUtCdDelstrengITittel(cda, innSkrift);
			break;
			
		case 5:
			tekstgr.skrivUtCdArtist(cda,innSkrift);
			break;
			
		case 6:
			tekstgr.skrivUtStatistikk(cda);
			break;
			
		case 7:
			System.out.println("Anatll CD-er: " + cda.antall());
			break;
			
		case 8:
			tekstgr.oversiktTekst();
			break;
			
		case 0:
			Fil.skrivTilFil(cda,filnavn);
			System.out.println("Handlingene er gjennomført og skrevet ut til filen: " + filnavn);
			break;
			
		default: System.out.println("Ugyldig handling");
		}
	}
	

}
	