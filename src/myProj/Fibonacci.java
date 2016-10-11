package myProj;

import java.security.InvalidParameterException;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(findFibRecursive(10));
		int prev = 1;
		int cur = 1;

		System.out.print(prev + " " + cur + " ");
		int temp;
		for (int i = 3; i <= 46; i++) {
			temp = prev;
			prev = cur;
			cur += temp;
			if (cur < 0) {
				throw new InvalidParameterException("ERROR: Fibonacci number will exceed MAXINT, maximum allowed is " + (i-1));
			}
			System.out.print(cur + " ");
		}
	}
	
	public static int findFib(int n) {
		if (n <= 0) {
			throw new InvalidParameterException("ERROR: Parameter must be greater than 0, you entered " + n);			
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		int prev = 1;
		int cur = 1;

		int sum = 0;
		for (int i = 3; i <= n; i++) {
			sum = prev + cur;
			prev = cur;
			cur = sum;
		}
		return sum;
	}

	public static int findFibRecursive(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		return findFibRecursive(n-1) + findFibRecursive(n-2);
	}
}
