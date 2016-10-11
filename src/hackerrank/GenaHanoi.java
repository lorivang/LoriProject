package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class GenaHanoi {
	
	static Deque<Integer> s1 = new ArrayDeque<Integer>();
	static Deque<Integer> s2 = new ArrayDeque<Integer>();
	static Deque<Integer> s3 = new ArrayDeque<Integer>();
	static Deque<Integer> s4 = new ArrayDeque<Integer>();

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int a[] = new int[N];
        for(int a_i=0; a_i < N; a_i++){
            a[a_i] = in.nextInt();
        }
        
        initializeStacks(a);
        
        System.out.println(solveHanoi(N-1));
    }

	/**
	 * Return the stacks to the original state, i.e. all the discs on s1 in
	 * Ascending order. Another way to generate the unique optimal iterative
	 * solution:
	 * 
	 * Number the disks 1 through n (largest to smallest).
	 * 
	 * If n is odd, the first move is from peg A to peg C. If n is even, the
	 * first move is from peg A to peg B.
	 * 
	 * Now, add these constraints:
	 * 
	 * No odd disk may be placed directly on an odd disk. No even disk may be
	 * placed directly on an even disk. There will be sometimes two possible
	 * pegs: one will have disks and the other will be empty. Place the disk in
	 * the non-empty peg. Never undo your previous move (that is, do not move a
	 * disk back to its immediate last peg).
	 * 
	 */
	private static int solveHanoi(int largest) {
		int count = 0;
		Deque<Integer> empty;
		Deque<Integer> odd;
		Deque<Integer> even;
		// First empty s1 (down to largest disk)
		if (!s1.isEmpty() && s1.peekLast() == largest) {
			Iterator<Integer> backwards = s1.descendingIterator();
			while (backwards.hasNext()) {
				if (backwards.next() == largest) { // correct element is already
													// at the bottom.
					largest--;
				}
			}
		}
		
		empty = assignEmpty();
		even = assignEven(empty);
		odd = assignOdd(empty, even);

		count += removeAllButLast(largest + 1, s1, odd, even);
		// Stop when other 3 pegs are empty
		while (!s2.isEmpty() || !s3.isEmpty() || !s4.isEmpty()) {
			count += removeAllButLast(largest, empty, odd, even);
			s1.push(empty.pop());
			count++;
			largest--;
			empty = assignEmpty();
			even = assignEven(empty);
			odd = assignOdd(empty,even);
		}
		
		return count;
	}

	private static int removeAllButLast(int largest, Deque<Integer> source, Deque<Integer> odd, Deque<Integer> even) {
		int count = 0;
		while (!source.isEmpty() && source.peek() != largest) {
			if (even.isEmpty() || source.peek() < even.peek()) {
				even.push(source.pop());				
			} else if (odd.isEmpty() || source.peek() < odd.peek()){
				odd.push(source.pop());
			} else {
				// forced to put it on empty
				source.push(source.pop());
				count++;
				break;
			}
			count++;
		}
		return count;
	}

	private static Deque<Integer> assignOdd(Deque<Integer> empty, Deque<Integer> even) {
		if (empty != s4 && even != s4 ) {
			return s4;
		}
		if (empty != s3 && even != s3) {
			return s3;
		}
		return s2;
	}

	private static Deque<Integer> assignEven(Deque<Integer> empty) {
		int s2val = (s2.isEmpty() ? 0 : s2.peek());
		int s3val = (s3.isEmpty() ? 0 : s3.peek());

		if (empty != s2 && s2val % 2 == 0) {
			return s2;
		}
		if (empty != s3 && s3val % 2 == 0) {
			return s3;
		}
		return s4;
	}

	private static Deque<Integer> assignEmpty() {
		int s2val = (s2.isEmpty() ? -1 : s2.peekLast());
		int s3val = (s3.isEmpty() ? -1 : s3.peekLast());
		int s4val = (s4.isEmpty() ? -1 : s4.peekLast());

		if (s2val > s3val && s2val > s4val) {
			return s2;
		}
		if (s3val > s4val) {
			return s3;
		}
		return s4;
	}

	/**
	 * Given the input list of stacks, a, distribute among our Stack objects.  Start from the end because the largest has to be at the bottom of the stack.
	 */
	private static void initializeStacks(int[] a) {
		for (int i = a.length-1; i >= 0; i--) {
			switch (a[i]) {
			case 1 : s1.push(i);
					break;
			case 2 : s2.push(i);
					break;
			case 3 : s3.push(i);
					break;
			case 4 : s4.push(i);
					break;
			
			}
		}
		
	}
}
