package no.hvl.dat102.Taarn;

public class TowersOfHanoi {
	private int totalDisks;
	private int flyttinger;
	
	public TowersOfHanoi(int disks) {
		totalDisks = disks;
		flyttinger = 0;
	}
	
	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
		System.out.println("Antall flyttinger " + flyttinger);
	}
	private void moveTower(int numDisks, int start, int end, int temp) {
		if(numDisks == 1) {
			//moveOneDisk(start, end);
			flyttinger++;
		}else {
			moveTower(numDisks-1, start, temp, end);
			//moveOneDisk(start, end);
			flyttinger++;
			moveTower(numDisks-1, temp, end, start);
		}	
	}
	
	//private void moveOneDisk(int start, int end) {
		//flyttinger++;
		//System.out.println("Flytt en disk fra: " + start + " til " + end);
	//}
	
}
