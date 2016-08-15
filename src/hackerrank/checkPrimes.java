package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import static java.lang.System.in;

public class checkPrimes {

	class Prime {
		public void checkPrime(int... nums) {
			for (int num : nums) {
				if (isPrime(num)) {
					System.out.print(num + " ");
				} 
					
			}
			System.out.println();
		}

		private boolean isPrime(int num) {
			if (num <= 1) {
				return false;
			}
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		checkPrimes cp = new checkPrimes();
		Prime ob=cp.new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		} catch (Exception e){
		}
		}
}
