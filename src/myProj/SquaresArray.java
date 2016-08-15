package myProj;

import java.util.Arrays;

public class SquaresArray {

	public static void main(String[] args) {
		int[][] tests = {{-2,-1,0,1,2,3,4,5}};
		for (int[] test : tests) {
		// Given a sorted list of int (pos, neg),return list of squares.
		// start at either end ... place sqrs from end to front.
		int front = 0;
		int end = test.length-1;
		int [] out = new int[test.length];
		int outptr = end;
		while (front < end) {
			if (Math.abs(test[front]) > Math.abs(test[end])) {
				out[outptr--] = (int) Math.pow(test[front++], 2);
			} else {
				out[outptr--] = (int) Math.pow(test[end--], 2);				
			}
		}
		System.out.println(Arrays.toString(out));
		}
	}


}
