package no.hvl.dat102;

public class KlientTallfoelge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tallfoelge t = new Tallfoelge();
		
		for (int i = 0; i < 10; i++){
		System.out.println("F�lgen av n = " + i + " er " + t.foelge(i));
		}
	}

}
