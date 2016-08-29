package hackerrank;

import java.util.Scanner;

/**
 * Given an array of elements, find the maximum possible sum of a
 * 
 * - Contiguous subarray 
 * - Non-contiguous (not necessarily contiguous) subarray.
 * 
 * Empty subarrays/subsequences should not be considered.
 *
 */
public class MaxSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for (int i = 1; i <=k; i++){
            int n = in.nextInt();
            int arr[] = new int[n];
            int noncontigsum = Integer.MIN_VALUE;

            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
                if (arr[arr_i] > noncontigsum){
                    noncontigsum = arr[arr_i];
                }
            }
            if (noncontigsum > 0) {
                noncontigsum = (arr[0] > 0 ? arr[0] : 0);
            }
            int contigsum = arr[0];
            int currentMax = arr[0];
            for(int j = 1; j < arr.length; j++) {
            	// if the new sum would be less than the next element, start over with next element.
                if (contigsum + arr[j] < arr[j]) {
                    contigsum = arr[j];
                } else {
                    contigsum += arr[j];
                }
                currentMax = Math.max(contigsum, currentMax); 
                // Only pay attention to the positive values for noncontigsum
                if (arr[j] > 0) {
                    noncontigsum += arr[j];
                }
            }
            System.out.println(currentMax + " " + noncontigsum);
        }
    }
}
