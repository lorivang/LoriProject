package hackerrank;

import java.util.Scanner;

public class RotateArray {
	
	public static void rotateLeft(int[] arr, int k) {
		int n = arr.length;
        for (int i = 0; i < n; i++) {
            k = k % n;
            int oldPos = (i + k) % n;
            System.out.print(arr[oldPos] + " ");
        }		
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int marray[] = new int[m];
        for(int arr_i=0; arr_i < m; arr_i++){
            marray[arr_i] = in.nextInt();
        }
    
        for (int i = 0; i < m; i++) {
            System.out.println(arr[((marray[i] -k) % n + n) % n]);
        }
}
}
