



public class Summer {
	
	public static void main(String[] args){
		int n = 100;
		//int sum = totalSum(n);
		
		
		//System.out.println("Summen av n = " + n + sum);
		
		//System.out.println(finnLedd(10));
		/*int i = 0;
		while(i < 10) {
		System.out.println(finnLedd(i));
		i++;
		}*/
		skrivUtLedd(10);
		}
	

	//a
	public static int totalSum(int n) {
		return leggeSammen(n);
	}
	
	private static int leggeSammen(int n) {
		int sum;
		if(n == 1) {
			sum = 1;
		}else {
			sum = leggeSammen(n-1) + n;
		}
		return sum;
	}
	
	
	//b
	public static void skrivUtLedd(int n) {
		int i = 0;
		while (i < n) {
			System.out.println("Ledd nr." + (i+1) + " = " + finnLedd(i));
			i++;
		}
	}
	
	private static int finnLedd(int n) {
		int ledd = 0;
		
		if(n == 0) {
			ledd = 2;
		} else if(n == 1){
			ledd = 5;
		} else if (n > 1){
			ledd = ((5*finnLedd(n-1)) - (6*finnLedd(n-2)) + 2);
				
		}
		
		return ledd;
	}
	
	//c
	public static int Hanoi(int n) {
		int flytt = 0;
		
		if(n == 1) {
			flytt = 1;
		} else if(n > 1){
			
			
		}
		return flytt;
	}
	
}
