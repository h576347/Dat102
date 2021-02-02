package no.hvl.dat102.hashing;


public class Test {
	
	public static void main(String[] args) {
		
		String s = "ab";
		String b = "123";
		
		int hash1 = s.hashCode();
		int hash2 = b.hashCode();
		
		System.out.println(hash1);
		System.out.println(hash2);
	
	}


}
