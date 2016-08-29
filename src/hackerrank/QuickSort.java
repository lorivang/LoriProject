package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static void quickSort(int[] ar) {
        partition(ar, 0, ar.length-1);
  }   
	

	static void partition(int[] ar, int begin, int end) {
		// exit criteria
		if (end - begin < 1) {
			return;
		}

        int pivot = ar[end];
        int start = begin;
        int tail = end;
        while (start < tail) {
            while (start <= end && ar[start] < pivot) {
                start++;
            }
            while (tail >= start && ar[tail] > pivot) {
                tail--;
            }
            if (start <= tail) {
                // swap
                int temp = ar[start];
                ar[start] = ar[tail];
                ar[tail] = temp;
                tail--;
                start++;
            }
        }
        printArray(ar, 0, ar.length);
        if (tail > begin) {
        	partition(ar, begin, tail);
        }
        if (end > start) {
        	partition(ar, start, end);
        }
 }   

static void printArray(int[] ar, int start, int end) {
   for(int n = start; n <end; n++){
      System.out.print(ar[n]+" ");
   }
     System.out.println("");
}
 
static void findMinDistPairs(int[] a) {
	// First calc the min distance
	int minDist = Integer.MAX_VALUE;
	for (int i = 1; i < a.length; i++) {
		minDist = Math.min(minDist, a[i] - a[i-1]);
	}
	// Now run the whole array again and print out the pairs that satisfy mindist
	for (int i = 1; i < a.length; i++) {
		if (a[i] - a[i-1] == minDist) {
			System.out.print(a[i-1] + " " + a[i] + " ");
		}
	}

}
public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int[] ar = new int[n];
     for(int i=0;i<n;i++){
        ar[i]=in.nextInt(); 
     }
     //quickSort(ar); 
     Arrays.sort(ar);
     in.close();
     findMinDistPairs(ar);
 }    


}
