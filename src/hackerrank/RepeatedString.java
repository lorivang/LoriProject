package hackerrank;

import java.util.Scanner;

public class RepeatedString {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
			long n = in.nextLong();

	        System.out.println(countAs(s, n));
	        
	    }

	/**
	 * Count the 'a' characters in the first n characters of an infinitely repeated string s.
	 * @param s
	 * @param n
	 * @return
	 */
	private static long countAs(String s, long n) {
		if (s.indexOf('a') < 0) {
			return 0;
		}
		long count = 0;
		int remainderCount = 0;
		int l = s.length();
		int remainder = (int) (n % l);
		long divisor = n / l;

		// count the a's in the string
		for (int i  = 0; i < remainder; i++) {
			if (s.charAt(i) == 'a') {
				count++;
				remainderCount++;

			}
		}
		for (int i = remainder; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				count++;
			}
		}
		
		return (count * divisor + remainderCount);
	}
}
