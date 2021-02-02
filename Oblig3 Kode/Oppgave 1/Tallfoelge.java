package no.hvl.dat102;

public class Tallfoelge {

	public int foelge(int n) {
		int sum = 0;
	
		if (n == 0) {
			sum = 2;
		} else if (n == 1){
			sum = 5;
		} else {
			sum = 5*foelge(n -1) - 6*foelge(n - 2) + 2;
		}
		
		return sum;
	}
}
