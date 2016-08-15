package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCream {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		for (int i =0; i<k; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			Map<Integer,Integer> map = new HashMap<>((int) (n * .75));
			int arr[] = new int[n];
			for(int arr_i=0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}
			// sort first
			int[] sorted = Arrays.copyOf(arr, n);
			Arrays.sort(sorted);
			int start = 0;
			int end = n-1;
			boolean done = false;
			while (!done && start<end) {
				if (sorted[start] + sorted[end] == m) {
					int f = origIndex(arr, 0, sorted[start]);
					int s = origIndex(arr, 0, sorted[end]);
					if (f == s) {
						s = origIndex(arr, f, sorted[end]);
					}
					System.out.println( Math.min(f, s) + " " + Math.max(f, s));
					done = true;					
				} else if (sorted[start] + sorted[end] < m) {
					start++;
				} else {
					end--;
				}
			}
		}
		in.close();
    }

	private static int origIndex(int[] arr, int start, int target) {
		// TODO Auto-generated method stub
		for (int i = start; i < arr.length; i++) {
			if (arr[i] == target) {
				return i+1;
			}
		}
		return 0;
	}

}
