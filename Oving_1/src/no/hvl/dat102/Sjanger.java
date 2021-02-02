package no.hvl.dat102;

public enum Sjanger {
	ROCK(1), POP(2), OPERA(3), KLASSISK(4);
	private int nr;

	private Sjanger(int n) { // Konstrukt�r
		this.nr = n; //         Ikke ordinaltallet
	}

	public int getNr() {
		return nr;
	}

	public static Sjanger finnSjanger(int n) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.nr == n) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}// metode

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}// metode

}