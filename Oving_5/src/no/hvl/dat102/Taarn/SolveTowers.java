package no.hvl.dat102.Taarn;

import java.time.Duration;
import java.time.Instant;

public class SolveTowers {

	public static void main(String[] args) {
		TowersOfHanoi towers = new TowersOfHanoi(16);
		Instant start = Instant.now();
		towers.solve();
		Instant slutt = Instant.now();
		Duration tid = Duration.between(start,slutt);
		System.out.println(tid);
		
	}
}
