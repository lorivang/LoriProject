package hackerrank;

import java.util.Scanner;

public class Hourglass2Darray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
        	for (int j = 0; j < 6; j++) {
        		arr[arr_i][j] = in.nextInt();
        	}
        }

        int max = Integer.MIN_VALUE;
        // The center of each hourglass
        for (int i = 1; i < 5; i++) {
        	for (int j = 1; j < 5; j++) {
        		max = Math.max(max, calcHourGlass(arr, i,j));
        	}
        }

        System.out.println(max);
        in.close();

}

	private static int calcHourGlass(int[][] a, int i, int j) {
		int sum = a[i][j];
		// do line above and below.
		for (int k =  j-1; k <= j+1; k++) {
			sum += (a[i-1][k] + a[i+1][k]);
		}
		return sum;
	}

}
