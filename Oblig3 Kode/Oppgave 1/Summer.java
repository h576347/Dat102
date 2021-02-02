package no.hvl.dat102;

public class Summer {
	
public int Summen(int n) {
	int sum = 0;
	
	if (n == 1) {
		sum = 1;
	} else {
		sum = n + Summen(n - 1);
	}
	
	return sum;
}

}
