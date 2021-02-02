package no.hvl.dat102.hashing;

public class Testing {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "ab";
		String s2 = "123";
		char[] ctab = { 'a', 'b', '1', '2', '3' };
		
		for (int i = 0; i < ctab.length; i++) {
			System.out.println(Character.codePointAt(ctab, i));
		}

		int hash1 = s1.hashCode();
		int hash2 = s2.hashCode();

		System.out.println(hash1);
		System.out.println(hash2);
		
		Student a = new Student (10, "Ole");
		Student b = new Student (10, "Ole");
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
//		
//		Student d = new Student(5, "Per");
//		Student e = d;
//		
//		System.out.println(d.equals(e));
//		System.out.println(d.hashCode());
//		System.out.println(e.hashCode());

	}

}
