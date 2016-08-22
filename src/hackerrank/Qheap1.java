package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Qheap1 {
	public enum Operation {
		ADD(1),
		DELETE(2),
		MIN(3);
		private int value;
		
		private Operation(int value) {
			this.value = value;
		}

		public static Operation valueOf(int o) {
			// TODO Auto-generated method stub
			switch (o) {
			case 1: return ADD;
			case 2: return DELETE;
			case 3: return MIN;
			default: return MIN;
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i =0; i<t; i++) {
			int o = in.nextInt();
			switch (Operation.valueOf(o)) {
			case ADD:
				int k = in.nextInt();
				pq.offer(k);
				break;
			case DELETE:
				int d = in.nextInt();
				pq.remove(d);
				break;
			case MIN:
				System.out.println(pq.peek());
				break;
			default:
			}
		
		}
	}
}
