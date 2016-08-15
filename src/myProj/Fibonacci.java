package myProj;

import java.security.InvalidParameterException;

public class Fibonacci {

	public static void main(String[] args) {
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

}
