package hackerrank;

import java.util.Scanner;

public class vmware2 {
    static int isArray_Balanced(int[] arr) {

    	int left = 0;
    	int right = 0;
    	if (arr.length <= 1) {
    		return 0;
    	}
    	// First add all elements except first.
    	for (int i = 1; i < arr.length; i++) {
    		right += arr[i];
    	}
    	
    	for (int i = 0; i < arr.length; i++) {
    		// for each element, determine left and right sums.
    		if (left == right) {
    			return 1;
    		}
    		left += arr[i];
    		right -= ((i+1 < arr.length) ? arr[i+1] : 0);
    	}
    	return 0;

    }

    public static void main(String[] args) {

    	int[] a = {};
    	System.out.println(isArray_Balanced(a));
    }
}
