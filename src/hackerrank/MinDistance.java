package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinDistance {
    public static void main(String[] args) {
    	Map<Integer, Integer> indexMap = new HashMap<>();
    	Integer runningMin = Integer.MAX_VALUE;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
            if (indexMap.containsKey(A[A_i])) {
            	int dist = A_i - indexMap.get(A[A_i]); 
            	if (dist == 1) { // special case, can't get any lower, so return
            		runningMin = dist;
            		break;
            	} else if (dist > runningMin) { // this can't be the min, so reset the index for this map entry
            		indexMap.put(A[A_i], A_i);
            	} else {  // dist <= runningMin, save new runningMin
            		runningMin = dist;            		
            	}
            } else {
            	indexMap.put(A[A_i], A_i);
            }
        }
        System.out.println(runningMin == Integer.MAX_VALUE ? "-1" : runningMin);
    }

}
