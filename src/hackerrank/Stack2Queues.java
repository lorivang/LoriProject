package hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class Stack2Queues {
	public enum Operation {
		ENQUEUE(1),
		DEQUEUE(2),
		PRINT(3);
		private int value;
		
		private Operation(int value) {
			this.value = value;
		}

		public static Operation valueOf(int o) {
			switch (o) {
			case 1: return ENQUEUE;
			case 2: return DEQUEUE;
			case 3: return PRINT;
			default: return PRINT;
			}
		}
		
	}

	public static void main(String[] args) {
		Stack<Integer> addS = new Stack<>();
		Stack<Integer> removeS = new Stack<>();

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			switch (Operation.valueOf(n)) {
			case ENQUEUE :
				int m = in.nextInt();
				addS.push(m);
				break;
			case DEQUEUE :
				if (removeS.isEmpty()) {
					if (addS.isEmpty()) {
						// nothing to remove, skip
						continue;
					}
					while (!addS.isEmpty()) {
						removeS.push(addS.pop());
					}
				}
				removeS.pop();
				break;
			case PRINT:
				if (removeS.isEmpty()) {
					if (addS.isEmpty()) {
						// nothing to remove, skip
						continue;
					}
					while (!addS.isEmpty()) {
						removeS.push(addS.pop());
					}
				}

				System.out.println(removeS.peek());
				break;
			}
		}
		in.close();
	}

}
