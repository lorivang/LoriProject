package hackerrank;


	import java.util.*;
	import java.util.Scanner;
	class MyCalculator{
		  int power(int n,int p) throws Exception {
			  if(n<0 || p<0) throw new Exception("n and p should be non-negative");
			  if(p==0) return 1;
			  return n*power(n,p-1);
		  }
	}
	
	class visa2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MyCalculator mc = new MyCalculator();
		while (in.hasNext()) {
			int n = in.nextInt();
			int p = in.nextInt();
			try {
				System.out.println(mc.power(n, p));
			} catch (Exception e) {
				System.out.println(e);
				//System.out.println(e.getClass() + ": " + e.getMessage());
			}

		}
	}

}
