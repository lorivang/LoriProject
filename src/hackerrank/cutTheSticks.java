package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class cutTheSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        Arrays.sort(arr);
    	System.out.println(arr.length);

        for (int i = 0; i < arr.length -1; i++) {
        	while (i + 1 < arr.length && arr[i] == arr[i+1]) {
        		i++; // skip dups
        	}
        	for (int j = i; j < arr.length; j++) {
        		arr[j] -= arr[i];
        	}
        	if (i != arr.length -1) {
        	System.out.println(arr.length  -1 - i);
        	}
        }
    }
    
}
