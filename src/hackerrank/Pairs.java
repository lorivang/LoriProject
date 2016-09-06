package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given n integers, count the number of pairs of integers whose difference is k. The integers are unique. 
 *
 */
public class Pairs {

	public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);
	     int n = in.nextInt();
	     int k = in.nextInt();
	     Set<Integer> s = new HashSet<>(); // No need for BST here, because we are only needing contains.
	     for(int i=0;i<n;i++){
	        s.add(in.nextInt()); 
	     }
	     int count = 0;
	     for (Integer i : s) {
	    	 if (s.contains(i + k)) {
	    		 count++;
	    	 }
	     }
	     System.out.println(count);
	}

}
