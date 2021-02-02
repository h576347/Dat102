package no.hvl.dat102;
import java.time.Duration;
import java.time.Instant;

public class KlientHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 16;
		TowersOfHanoi toh = new TowersOfHanoi(n);
		Instant start = Instant.now();
		toh.solve();
		Instant slutt = Instant.now();
		Duration tid = Duration.between(start, slutt);
		System.out.println("Antall flytt: " + toh.getAntallFlytt());
		System.out.println("Tiden det tok å løse Tower Of Hanoi med " + n + " brikker var " + tid);
	}

}
