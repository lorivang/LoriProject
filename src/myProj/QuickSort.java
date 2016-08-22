package myProj;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] tests = {//{5,4,2,7,1,3},
						//	{0,1,2,3,4},
						//	{5,4,3,2,1},
							{4,22,8,1,-7,0,4,1,13,8},
						//	{1,1,6,0,1,1,1,1},
							{1,0}};
		for (int[] test : tests) {
			System.out.println("Before : " + Arrays.toString(test));
			quickSort(test, 0, test.length -1);
			System.out.println("After  : " + Arrays.toString(test));
		}
	}

	private static void quickSort(int[] test, int start, int end) {
		// exit criteria
		if (end - start < 1) {
			return;
		}
		// pick a pivot
		int pivot = test[start + ((end - start)/2)];  // don't lose the pivot value in case of swap
		int i = start;
		int j = end;
		// put small things below pivot, big things above.
		while (i <= j) {
			while ( test[i] < pivot) {  // Note we don't need to test for i going too big because it will stop when i == pivot.
				i++;
			}
			while (test[j] > pivot) {
				j--;
			}
			// need to swap
			if (i <= j) {
				int temp = test[i];
				test[i] = test[j];
				test[j] = temp;
				i++;
				j--;
			}
		}
		
		// Now everything from start to j is below pivot, everything from i to end is bigger than pivot.
		//if (start < j) {
		quickSort(test, start, j);
		//}
		//if ( i < end) {
		quickSort(test, i, end);
		//}
	}

}
