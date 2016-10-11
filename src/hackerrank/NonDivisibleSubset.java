package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a set, , of distinct integers, print the size of a maximal subset, , of where the sum of any numbers in are not evenly divisible by .
 *
 */
public class NonDivisibleSubset {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        System.out.println(findSubsetSize(arr, k));
        in.close();
	}

	private static int findSubsetSize(int[] arr, int k) {
		int[] counts = new int[k];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			counts[arr[i] % k]++;
		}
		
		// Now we have our array of counts, find the min if count and its counterpoint.
		for (int i = 0; i < k/2 + 1; i++) {
			max = Math.max(max, Math.min(counts[i], counts[k-i-1]));
		}
		
		int cnt = counts[0] < 1 ? counts[0] : 1;
		for (int i = 1; i < k / 2 + 1; ++i) {
			if (i != k - i) {
				cnt += counts[i] > counts[k - i] ? counts[i] : counts[k - i];
			}
		}
		if (k % 2 == 0) {
			cnt += 1;
		}
		return cnt;
	}

}
