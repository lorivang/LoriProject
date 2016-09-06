package hackerrank;

import java.io.*;
import java.util.*;

interface PerformOperation {
	boolean check(int a);
}
class Odd implements PerformOperation {

	@Override
	public boolean check(int a) {
		return (a % 2 == 1);
	}
	
}
class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation is_odd() {
		return num -> (num % 2) == 1;
	}

	public PerformOperation is_prime() {
		return num -> (num == 2) || java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> (num % i) == 0);
	}

	public PerformOperation is_palindrome() {
		return num -> String.valueOf(num).equals(new StringBuilder(String.valueOf(num)).reverse().toString());
	}
}

public class Lambdas {
	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.is_odd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.is_prime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.is_palindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}
