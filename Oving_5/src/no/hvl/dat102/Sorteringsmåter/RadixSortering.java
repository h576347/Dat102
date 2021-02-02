package no.hvl.dat102.Sorteringsmåter;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import no.hvl.dat102.tabell.*;

public class RadixSortering {

	
	public static void main ( String[] args){ 
		//int[] liste = {7843, 4568, 8765, 6543, 7865, 4532,9987, 3241, 6589, 6622, 1211};
		Random tilfeldig = new Random();
		int min = 10;
		int max = 100;
		int n = 64000;
	
		int[] a = new int[n];
		
		
		
			for (int j = 0; j < n; j++){
				a[j] = tilfeldig.nextInt(max-min)+min;
				
				}
			
		
		String temp; 
		Integer tallObj;
		int siffer, tall;
		
		Instant start = Instant.now();
		
		
		TabellKoe<Integer>[] sifferKoer =(TabellKoe<Integer>[])(new TabellKoe[n]);
		
		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {      
			sifferKoer[sifferVerdi] = new TabellKoe<Integer>();  
		}
			/** sorterer liste */
			for (int posisjon = 0; posisjon < 2; posisjon++){//ytre løkke 
				for (int i = 0; i  < a.length; i++){//indre løkke
					temp   = String.valueOf (a[i]);
					siffer = Character.digit (temp.charAt(1-posisjon), 10); 
					sifferKoer[siffer].innKoe (new Integer(a[i]));
					}//indre løkke
				
				 tall = 0;    
				 for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++){            
					 while (!(sifferKoer[sifferVerdi].erTom())){
						 tallObj = sifferKoer[sifferVerdi].utKoe();               
						 a[tall] = tallObj.intValue();               
						 tall++;            
						 }//while         
					 }//for 
				 }//ytre løkke
			
				//for (int i=0; i < a.length; i++){                 
				// System.out.println (a[i]);
				// }
				
		
		Instant slutt = Instant.now();
		Duration tid = Duration.between(start,slutt);
		System.out.println(tid);
	}
}
