package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The longest common subsequence (LCS) problem is the problem of finding the
 * longest subsequence common to all sequences in a set of sequences (often just
 * two sequences). It differs from problems of finding common substrings: unlike
 * substrings, subsequences are not required to occupy consecutive positions
 * within the original sequences.
 *
 */
public class LongestCommonSubsequence {

	static Map<String, Integer> myMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();

        in.close();
        
        System.out.println(LCS_DP(a.toCharArray(), b.toCharArray()));
        System.out.println(LCS(a.toCharArray(), a.length() -1,b.toCharArray(), b.length() -1));
    }

	private static int LCS(char[] a, int aEnd, char[] b, int bEnd) {
		if (aEnd == 0 || bEnd == 0) {
			return 0;
		}
		String key = String.copyValueOf(a, 0, aEnd) + String.copyValueOf(b, 0, bEnd);
		if (myMap.containsKey(key)) {
			return myMap.get(key);
		}
		if (a[aEnd] == b[bEnd]) {
			// same end char, so max can be incremented, and a char removed from each string.
			int temp = 1 + LCS(a, aEnd-1, b , bEnd-1);
			myMap.put(key, temp);
			return(temp);
		} else {
			// try removing end of each string in turn and finding the max.
			int temp  = Math.max(LCS(a, aEnd-1, b, bEnd), LCS(a, aEnd,  b, bEnd-1));
			myMap.put(key, temp);

			return(temp);
		}
	}
	
	/**
	 * Dynamic Programming approach using matrix of counts.
	 */
	private static int LCS_DP(char[] a,char[] b) {
		int[][] dpMatrix = new int[a.length+1][b.length+1];
		// Seed the last row and column with 0's.  Note that a and b are same length.
		for (int i = 0; i <= a.length; i++) {
			dpMatrix[a.length][i] = 0;
			dpMatrix[i][a.length] = 0;
		}
		
		for (int i = a.length -1; i >= 0; i--) {
			for (int j = b.length -1; j >= 0; j--) {
				if (a[i] == b[j]) {
					// same char, increase count
					dpMatrix[i][j] = 1 + dpMatrix[i+1][j+1];
				} else {
					dpMatrix[i][j] = Math.max(dpMatrix[i+1][j], dpMatrix[i][j+1]);
				}
			}
		}
		return (dpMatrix[0][0]);

	}

}
