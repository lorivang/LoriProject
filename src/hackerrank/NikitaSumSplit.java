package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class NikitaSumSplit {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
        int n = in.nextInt(); 
        long[] arr = new long[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextLong();
        }
        System.out.println(maxScore(arr));
        }
        in.close();
	}

	private static int maxScore(long[] arr) {
		int score = doMaxScore(arr, 0, arr.length, sumArray(arr), 0);
		return score;
	}

	private static int doMaxScore(long[] arr, int start, int end, BigInteger bigInteger, int score) {
		if (end - start < 2) { // too short
			return score;
		}
		// special case for 0, note we can only have positive ints
		if (bigInteger == BigInteger.ZERO) {
			score += arr.length -1;
			return score;
		}
		if (bigInteger.mod(BigInteger.valueOf(2)) != BigInteger.ZERO) {
			return score;  // we cannot divide into 2 equal sums.
		}
		BigInteger half = bigInteger.divide(BigInteger.valueOf(2));
		BigInteger sum = BigInteger.ZERO;
		int i = start;
		while (i < end && sum.compareTo(half) == -1 ) {
			sum = sum.add(BigInteger.valueOf(arr[i++]));
		}
		if (sum.compareTo(half) == 0) {
			score++;
			int sLeft = doMaxScore(arr, start, i, bigInteger.subtract(half), score);
			int sRight = doMaxScore(arr, i, end, bigInteger.subtract(half), score);
			return Math.max(sLeft, sRight);
				
		}
		return score;
			
	}

	private static BigInteger sumArray(long[] arr) {
		BigInteger sum = BigInteger.ZERO;
		for (long i : arr) {
			sum = sum.add(BigInteger.valueOf(i));
		}
		return sum;
	}

}
