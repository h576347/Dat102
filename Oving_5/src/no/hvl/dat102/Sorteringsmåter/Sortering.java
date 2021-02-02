package no.hvl.dat102.Sorteringsmåter;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Sortering {
	private final static int MIN = 10;

	public static void main (String[] args){ 
		
		// Til bruk ved sortering av store tabellar
		Random tilfeldig = new Random();
		int n = 16000;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++){
			for (int j = 0; j < n; j++){
				a[i][j] = tilfeldig.nextInt();
			}
			}// sorter kvar rekke
		// start tidsmåling
		Instant start = Instant.now();
		for (int i = 0; i< antal; i++){
			kvikkSort2(a[i],0,a.length-1); // blir ein eindimensjonal tabell
			}        // slutt tidsmåling
		Instant slutt = Instant.now();
		Duration tid = Duration.between(start,slutt);
		System.out.println(tid);

		
		
	}
	
	
	public static <Integer extends Comparable<Integer>>void sorteringVedInsetting(Integer[] data) {
		for (int i = 0; i < data.length; i++) {
			Integer nokkel = data[i];
			int p = i;

			// Forskyver større verdier til høyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		}
	}
	public static <Integer extends Comparable<Integer>> void utvalgssortering (Integer[] data){
		int minste;
		Integer temp;
		for(int neste = 0; neste < data.length-1; neste++){
			minste = neste;
			for(int sok= neste+1; sok< data.length; sok++){
				if(data[sok].compareTo(data[minste]) < 0){
					minste = sok;
					}
				}  /** Bytt verdiene */      
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
			}//ytre}//metode
	}

	public static <Integer extends Comparable<Integer>> void bobleSort(Integer[] data) {
		int p, sok;
		Integer temp;
		for (p = data.length - 1; p >= 0; p--) {

			for (sok = 0; sok <= p - 1; sok++) {

				if (data[sok].compareTo(data[sok + 1]) > 0) {
					// Bytt verdiene
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			}
		}
	}

	public static <Integer extends Comparable<Integer>> void kvikkSort(Integer[] data, int min, int maks) {
		int posPartisjon;
		if (min < maks) { // minst to elementer
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}

	private static <Integer extends Comparable<Integer>> int finnPartisjon(Integer[] data, int min, int maks) {
		int venstre, hoyre;
		Integer temp, pivot;
		// pivot som første element. Boka bruker midterste
		pivot = data[min];
		venstre = min;
		hoyre = maks;
		while (venstre < hoyre) {// ytre løkke
			/** Søker et element som er > enn pivot */
			/** Sikrer at partisjoneringsprosessen vil fortsette så lenge venstre < hoyre */
			while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			/** Søker et element som er <= enn pivot */
			while (data[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}
			/** bytter elementene */
			if (venstre < hoyre) {
				temp = data[venstre];
				data[venstre] = data[hoyre];
				data[hoyre] = temp;
			}
		} // while – ytre løkke
		/** flytter pivot til riktig og sin endelige plass */
		temp = data[min];
		data[min] = data[hoyre];
		data[hoyre] = temp;
		return hoyre;

	}
	 
	public static <Integer extends Comparable<Integer>> void fletteSort(Integer[] tabell, int forste, int siste){ 
		 if(forste < siste){
			 // minst to elementer    
			 int midten = (forste + siste)/2;  
			 // Sorter venstre halvdel tabell[forste, midten];
			 fletteSort(tabell, forste, midten);   
			 // Sorter høyre halvdel tabell[midten+1, siste];
			 fletteSort(tabell, midten+1, siste);  
			 // Fletter de to halvdelene
			 flette(tabell, forste, midten, siste);   
			 }
		 }//fletteSort


	 

	private static <Integer extends Comparable<Integer>> void flette(Integer[] tabell, int forste, int midten, int siste) {

		int stor = siste - forste + 1;
		Integer[] hjelpeTabell = (Integer[]) (new Comparable[stor]);
		// Initierer lokale indekser
		// start og slutt på venstre deltabell
		int forste1 = forste;
		int siste1 = midten; // start og slutt på høyre deltabell
		int forste2 = midten + 1;
		int siste2 = siste;

		int indeks = 0;
		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tabell[forste1].compareTo(tabell[forste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[forste1];
				forste1++;
			} else {
				hjelpeTabell[indeks] = tabell[forste2];
				forste2++;
			}
			indeks++;
		} // while
		// kopiere resten av venstre del (kan være tom)
		while (forste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[forste1];
			forste1++;
			indeks++;
		} // while// kopiere resten av høyre del (kan være tom)
		while (forste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[forste2];
			forste2++;
			indeks++;
		} // while
		// Kopier resultatet tilbake til den originale tabellen
		int h = 0;
		for (indeks = forste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h];
			h++;
		}
	}// flette */
	
	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks){
		kvikkSort2(data, min, maks);
		sorteringVedInnsetting2(data, min, maks);
		} 
	public static <T extends Comparable<T>> void kvikkSort2(T[] data, int min, int maks){
		int posPartisjon;
		if ((maks -min +1) > MIN) {//antall elementer > MIN ?
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort2(data, min, posPartisjon -1);
			/** Sorterer høyre side */
			kvikkSort2(data, posPartisjon + 1, maks); 
			
		}
			
		}// metode
	
	public static <T extends Comparable<T>> void sorteringVedInnsetting2(T[] data, int forste, int siste){
		for (int indeks = forste + 1; indeks <= siste; indeks++) {
			T nokkel = data[indeks];
		}
	}

}
