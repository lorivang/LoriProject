package myProj;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find k biggest numbers in array
 *
 */
public class BiggestNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] tests = {{4,1,7,0,-5,6},
				{0,1,2,3,4,5,6,7,7,7,7,8},
				{8,1,8,2,8,3,8,4}};
		for (int[] test : tests) {
			System.out.println(Arrays.toString(findBiggest(test, 4)));
			System.out.println(Arrays.toString(findBiggest(test, 2)));
			System.out.println(Arrays.toString(findBiggest(test, 8)));
		}
	}

	private static Object[] findBiggest(int[] test, int k) {

		if (test.length < k) {
			return null;
		}
		int [] out = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		for (int i = 0; i < k; i++) {
			// arbitrarily add the first k numbers to the queue
			pq.add(test[i]);
		}
		// for remaining elements, only add if they are bigger than smallest element.
		for (int i = k; i < test.length; i++) {
			if (test[i] > pq.peek()) {
				pq.poll(); // remove the least
				pq.add(test[i]);
			}
		}
		return pq.toArray();

	}

}
