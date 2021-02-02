package mainmetode;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import no.hvl.dat102.Sorteringsmåter.Sortering;

public class Klient {

	public static void main (String[] args){ 
		
		// Til bruk ved sortering av store tabellar
		Random tilfeldig;
		int n = 32000;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		//for (int i = 0; i < antal; i++){
		//	for (int j = 0; j < n; j++){a[i][j] = tilfeldig.nextInt();
			//}
			//}// sorter kvar rekke
		// start tidsmåling
		/*Instant start1 = Instant.now();
		for (int i = 0; i< antal; i++){
			Sortering.sorteringVedInnsetting(a[i]); // blir ein eindimensjonal tabell
			}        // slutt tidsmåling
		Instant slutt1 = Instant.now();
		Duration tid1 = Duration.between(start1,slutt1);
		System.out.println(tid1);
		}*/
		
		
	}
}
