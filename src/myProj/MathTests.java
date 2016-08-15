package myProj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathTests {

	public static void main(String[] args) {
		isArmstrong(1); isArmstrong(153);
		System.out.println("Armstrongs up to " + Integer.MAX_VALUE + ": " + Arrays.toString(findArmstrongs(100000).toArray()));
		int[][] tests = {{-1,8,3,1,-2,-6,-9,10,-1,8,-8,0,9,-4,2}, { 0, 1}, {-1,-1,1,1,0,0,0}, {0,0,0}};
		System.out.println(find2ndMax(tests[0]));
		for (int[] t : tests) {
			System.out.println("Finding 3sum of " + Arrays.toString(t));
			List<int[]> result = findTriple_3(t);
			for (int[] r : result) {
				System.out.println(Arrays.toString(r));
			}
		}

	}

	private static int find2ndMax(int[] in) {
		if (in.length < 2) {
			return -1;
		}
		int max = Math.max(in[0], in[1]);
		int sndmax = Math.min(in[0], in[1]);
		for (int i = 1; i < in.length; i ++) {
			if (in[i] > max) {
				sndmax = max;
				max = in[i];
			} else if (in[i] > sndmax) {
				sndmax = in[i];
			}
		}
		return sndmax;
	}
	
	private static List<int[]> threeSum(int[] input) {
		List<int[]> temp = new ArrayList<>(input.length*2); // init with sufficient space.
		int next = 0;
		Arrays.sort(input);
		// removing dups would help with unique return vals. or you can always
		// just check the previous answer to make sure they are not the same.
		for (int i = 1; i < input.length - 1; i++) {
			if (i == 1 || input[i] > input[i-1]) { // avoid dups
			int small = 0;
			int large = input.length - 1;
			while (i > small && i < large) {
				int sum = input[small] + input[i] + input[large];
				if (sum == 0) {
					// found one!
						temp.add(next++, new int[] { input[small], input[i], input[large] });
					// Don't forget to advance both pointers!
						// avoid dups by advancing over duplicate numbers.
					small++;
					large--;
					while (small < large && input[small] == input[small - 1]) {
						small++;
					}
					while (small < large && input[large] == input[large + 1]) {
						large--;
					}
				} else if (sum < 0) { // too small, advance small index
					small++;
				} else {
					large--;
				}
			}
		}
		}
		return (temp);
	}
	
	private static List<Integer> findArmstrongs(int limit) {
		List<Integer> ret = new ArrayList<>();
		// determine dimensions of limit
		int dim = 0;
		for (int i = 1; i < limit; i*=10, dim++);
		
		for (int i = 0; i < limit; i++) {
			if (isArmstrong(i)) { // found one!
				ret.add(i);
			}
		}
		return ret;
	}

	private static boolean isArmstrong(int i) {
		int sum = 0;
		int temp = i;
		
		String junk = i + "";
		int dim = junk.length();
		while (temp > 0) {
			int place = temp % 10;
			sum += Math.pow(place, dim);
			temp /= 10;
		}
		
//		for (int j = 1; temp >= Math.pow(10, j-1); j++) {
//			Double placeval = (temp % Math.pow(10, j)) / Math.pow(10, j-1);
//			
//			sum += Math.pow(placeval, 3);
//			temp -= placeval * Math.pow(10, j-1); // zero out  place val;
//		}
		return (sum == i);
	}
	
	   private static List<int[]> findTriple_3(int[] A) {
		   List<int[]> retVal = new ArrayList<>(A.length * 2);
		   // Maps negative sum to the 2 ints that formed it.
	        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
	        for (int i = 0, l = A.length; i < l; i++) {
	            map.clear();
	            for (int j = i + 1; j < l; j++) {
	                if (map.containsKey(A[j])) {
	                    int[] pair = map.get(A[j]);
	                    retVal.add(new int[]{pair[0], pair[1], A[j]});
	                } else
	                    map.put(-A[i] - A[j], new int[]{A[i], A[j]});
	            }
	        }
	        return retVal;
	    }
}
