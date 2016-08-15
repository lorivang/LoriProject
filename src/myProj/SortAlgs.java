package myProj;

import java.util.Arrays;
import java.util.Comparator;

public class SortAlgs {
	
	public class myCompare implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {		
			if (o1 == o2) return 0;
			if (o1 < o2) return -1;
			return 1;
		}		
	}
	
	public static Integer[] bubbleSort(Integer[] a, Comparator c) {
		Integer[] b = new Integer[a.length];
		b = a.clone();
		for (int j = 0; j < b.length - 1; j++) {
			for (int i = 1; i < b.length; i++) {
				if (b[i].compareTo(b[i - 1]) < 0) {
					xorTrick(b, i, i-1);
				}
			}
		}
		return b;
	}

	private static void xorTrick(Integer[] b, int i, int j) {
		// Cleaver XOR swap.
		if (i == j) return;
		b[i] = b[i] ^ b[j];
		b[j] = b[i] ^ b[j];
		b[i] = b[i] ^ b[j];
	}

	public static int[] quickSort(int[] test) {
		int[] b = new int[test.length];
		b = test.clone();
		doQuickSort(b, 0, b.length - 1);
		return b;
	}
	
	private static void doQuickSort(int[] b, int low, int high) {
		if (b.length <= 1) {
			return;
		}
		int pivot = low + ((high - low) / 2);
		int i = low; 
		int j = high;
		while (i < j) {
			// Find a low number bigger than the pivot.
			while (b[i] < b[pivot]) {
				i++;
			}
			// Find a high number smaller than pivot
			while (b[j] > b[pivot]) {
				j--;
			}
			// if i,j haven't crossed paths, swap them.
			if (i <= j) {
				xorTrick(b, i, j);
				i++;
				j--;
			}
		}
		// recursively quicksort on low and/or high parts.
		if (low < j) {
			doQuickSort(b, low, j);
		}
		if (i < high) {
			doQuickSort(b, i, high);
		}
	}
	
	private static void xorTrick(int[] b, int i, int j) {
		int temp = b[i];
		b[i] = b[j];
		b[j] = temp;
		
	}

	public static Integer[] mergeSort(Integer[] a) {
		Integer[] b = new Integer[a.length];
		b = a.clone();
		doMergeSort(b);
		return b;
	}

	private static void doMergeSort(Comparable[] b) {
		if (b.length <= 1) {
			return;
		}
		int mid = b.length / 2;
		//Integer[] front = new Integer[mid];
		//Integer[] back = new Integer[b.length - mid];
		Comparable[] front = Arrays.copyOfRange(b, 0, mid);
		Comparable[] back = Arrays.copyOfRange(b, mid, b.length);
		doMergeSort(front);
		doMergeSort(back);
		merge(front, back, b);	
		
	}

	private static void merge(Comparable[] front, Comparable[] back, Comparable[] result) {
		int f = 0;
		int b = 0;
		for (int i = 0; i < result.length; i++) {
			// run out of things in front, just copy back
			if (f >=  front.length) {
				result[i] = back[b++];
				// Similarly if back is done, use front
			} else if (b >= back.length) {
				result[i] = front[f++];
				// otherwise compare them
			} else if (front[f].compareTo(back[b]) < 0) {
				result[i] = front[f++];
			} else {
				result[i] = back[b++];
			}				
		}		
	}
	
	public static void quickSort(int[] a, int low, int high) {
		// end recursion
		if (high - low < 1) {
			return;
		}
		// pick a pivot (don't forget to offset it by low!!!
		int pivot = low + ((high - low) /2);
		int i = low;
		int j = high;
		while (i < j)  {
			// find an element on the low side that is greater than the pivot. Note the < is necessary to increment i.
			while (a[i] < a[pivot]) {
				i++;
			}
			// find an element on the high side that is less than the pivot.
			while (a[j] > a[pivot]) {
				j--;
			}

			if (i <= j) { // need the <= equals part to keep incrementing i,j
				// swap elements
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		// quick sort the remaining low and high part.
		if (low < j) {
			quickSort(a, low, j);
		}
		if (i < high) {
			quickSort(a, i, high);
		}
	}
	
	public static void heapSort(Comparable[] input) {
		// I'm not doing this :-P
	}

	public static void main(String[] args) {
		Integer[] test1 = {5,2,9,4,11,5,2,4,0,9,2};
		Integer[] test2 = {9,8,7,6,5,4,3,2,1,0};
		System.out.println(Arrays.toString(test1));
//		System.out.println(Arrays.toString(quickSort(test1)));
		System.out.println(Arrays.toString(test2));
		System.out.println(Arrays.toString(mergeSort(test2)));
		SortAlgs sa = new SortAlgs();
		System.out.println(Arrays.toString(bubbleSort(test1, sa.new myCompare())));
		//System.out.println(Arrays.toString(quickSort(test1)));

	}

}
