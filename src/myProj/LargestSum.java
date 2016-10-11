package myProj;

import java.util.Arrays;
import java.util.Scanner;

public class LargestSum {

	private static int currentMax;
	private static int saveStart;
	private static int saveEnd;
	private static int straightSum;
	
	static int largestSum(int[] a) {

		// the trick is that if sumSoFar+a[i] is < a[i], drop sumSoFar and start with a[i].
		int sumSoFar = a[0];
		int startSoFar = 0;
		currentMax = sumSoFar;
		saveStart = 0;
		saveEnd = 0;
		straightSum = 0;
		for (int i = 1; i < a.length; i++) {
			straightSum += (a[i] > 0 ? a[i] : 0);
			if (sumSoFar + a[i] < a[i]) { // start over at i
				startSoFar = i;
				sumSoFar = a[i];
			} else {
				sumSoFar += a[i];
			}
			if (sumSoFar >= currentMax) {
				currentMax = sumSoFar;
				saveStart = startSoFar;
				saveEnd = i;
			}
		}
		return currentMax;
	}
	
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
	                if (contigsum + arr[j] < arr[j]) {
	                    contigsum = arr[j];
	                } else {
	                    contigsum += arr[j];
	                }
	                currentMax = Math.max(contigsum, currentMax); 
	                if (arr[j] > 0) {
	                    noncontigsum += arr[j];
	                }
	            }
	            System.out.println(currentMax + " " + noncontigsum);
	        }

		int[][] tests =  {
				{1, 2, 3, 4},
			{2, -1, 2, 3, 4, -5},
//			{3, -1, 2, 0, -4, 0},
//			{0, -4, -2, 12, 8, -34, 9},
//			{1,2,3,4,5,6,7,8,9},
//			{-1,2,5,-5,6},
//			{-1,-2,-3}
		};

		for (int[] test : tests) {
			largestSum(test);
			System.out.println(Arrays.toString(test));
			System.out.println("Largest Sum : " + currentMax + " straightSum " + straightSum + " start : " + saveStart + " end : " + saveEnd);
			System.out.println(Arrays.toString(Arrays.copyOfRange(test, saveStart, saveEnd+1)));
			
		}
	}

}
