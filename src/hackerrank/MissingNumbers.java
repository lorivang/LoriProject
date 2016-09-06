package hackerrank;

import java.util.Scanner;

/**
 * find numbers in b that are not in a.  Print in sorted order.
 * There is a maximum range of 100 numbers.
 *
 */
public class MissingNumbers {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            a[arr_i] = in.nextInt();
        }
        int m = in.nextInt();

        int b[] = new int[m];
        int min = Integer.MAX_VALUE;
        for(int arr_i=0; arr_i < m; arr_i++){
            b[arr_i] = in.nextInt();
            min = Math.min(min, b[arr_i]);
        }
        
        int[] numCount = new int[100]; // maximum range is 100
        int base = (min/100) * 100; // this will be needed to get original numbers back.
        int rotation = min % 100;
        for (int i = 0; i < b.length; i++)  {
        	numCount[(b[i] - rotation) % 100]++;
        }
        for (int j = 0; j < a.length; j++) {
        	numCount[(a[j] - rotation) % 100]--;
        }
        for (int k = 0; k < numCount.length; k++) {
        	if (numCount[k] != 0) {
        		System.out.print(base + k + rotation + " ");
        	}
        }
        in.close();
	}

}
