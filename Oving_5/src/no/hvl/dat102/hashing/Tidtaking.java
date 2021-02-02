package no.hvl.dat102.hashing;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;


public class Tidtaking {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Random tilfeldig = new Random();

				int antal = 1000000;
				int tall= 376;
				ArrayList<Integer> binsok = new ArrayList<Integer>();
				HashSet<Integer> hTab = new HashSet<Integer>();
				
				
				//Integer[][] a = new Integer[antal][n];
				// set inn tilfeldige heiltal i alle rekker
				for (int i = 0; i < antal; i++){
					tall = (tall + 45731) % 1000000;
					binsok.add((Integer) tall);
					hTab.add((Integer)tall);
					
					}// sorter kvar rekke
				binsok.sort(null);
				
				
				Integer[] tab = new Integer[10000];
				Random random = new Random();
				
				for(int i = 0; i < tab.length; i++) {
					tall = random.nextInt(1000000);
					tab[i] = (Integer) tall;
					
				}
				int antFunn = 0;
				// start tidsmåling
				Instant start = Instant.now();
				for(int i = 0; i < tab.length; i++) {
					Integer sokElement = tab[i];
					boolean eksisterer = hTab.contains(sokElement);
					
					if(eksisterer) {
						antFunn++;
					}
				}
			
				     // slutt tidsmåling
				Instant slutt = Instant.now();
				Duration tid = Duration.between(start,slutt);
				System.out.println("Tiden ved bruk av hashing: " + tid + " " + antFunn);
				
				antFunn = 0;
				start = Instant.now();
				for(int i = 0; i < tab.length; i++) {
					Integer sokElement = tab[i];
					boolean eksisterer = binearSoek(binsok,0, 999999, sokElement);
					
					if(eksisterer) {
						antFunn++;
					}
				}
				slutt = Instant.now();
				tid = Duration.between(start,slutt);
				System.out.println("Tiden ved bruk av binærsøk: " + tid + " " + antFunn);

	}
	public static <T extends Comparable<T>> boolean binearSoek(ArrayList<T> data, int min, int maks, T el) {
		boolean funnet;
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data.get(midtpunkt));

		if (min > maks) { // basistilfelle, ingen element
			funnet = false;
		} else if (resultat == 0) {
			funnet = true;
		} else if (resultat < 0) {
			funnet = binearSoek(data, min, midtpunkt - 1, el);
		} else {
			funnet = binearSoek(data, midtpunkt + 1, maks, el);
		}

		return funnet;

	}

}
