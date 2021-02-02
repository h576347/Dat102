package no.hvl.dat102.hashing;

public class Student {
	private int snr;
	private String navn;
	
	public Student(int snr, String navn) {
		this.snr  = snr;
		this.navn = navn;
	}
	
	public static void main(String[] args) {
		Student a = new Student(10, "ole");
		Student b = new Student(10, "ole");
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}
	@Override
	public int hashCode() {
		return navn.hashCode() * snr;
	}

}
