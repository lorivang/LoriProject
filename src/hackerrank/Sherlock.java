package hackerrank;

import java.util.Scanner;

/**
 * @author Lori 
 * Watson gives Sherlock an array of length . Then he asks him to
 *         determine if there exists an element in the array such that the sum
 *         of the elements on its left is equal to the sum of the elements on
 *         its right. If there are no elements to the left/right, then the sum
 *         is considered to be zero. 
 */
public class Sherlock {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		for (int i =0; i<k; i++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			int backSum = 0;

			for(int arr_i=0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
				backSum +=arr[arr_i];
			}
			int frontSum = 0;
			for (int j = 0; j < n; j++) {
				backSum -= arr[j];
				if (frontSum == backSum) {
					System.out.println("YES");
					break;
				}
				frontSum += arr[j];
			}
			if (frontSum != backSum) {

				System.out.println("NO");
			}
		}
		in.close();
	}
}
