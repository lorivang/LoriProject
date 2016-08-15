package myProj;

import java.util.Stack;

public class StackasQueue {

	public class MyQueue<T> {
		// Implement a queue using 2 stacks.
		private Stack<T> pushS = new Stack<>();
		private Stack<T> popS = new Stack<>();
		private Stack<T> current = pushS;
		
		public void push(T t) {
			if (current != pushS) {
				exchangeStacks(pushS, popS);
			}
			pushS.push(t); 
		}

		public T pull() {
			if (current != popS) {
				exchangeStacks(popS, pushS);
			}
			return popS.pop(); 
		}

		private void exchangeStacks(Stack<T> s1, Stack<T> s2) {
			// transfer the pop stack to the push stack.
			s1.clear();
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			current = s1;
		}

		public boolean isEmpty() {
			return pushS.isEmpty() && popS.isEmpty();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackasQueue saq = new StackasQueue();
		MyQueue<Integer> mq = saq.new MyQueue<>();
		Integer[] testData = {1,2,3,4,5,6,7,8};
		for (Integer i : testData) {
			mq.push(i);
		}
		while (!mq.isEmpty()) {
			System.out.println("Pull " + mq.pull());
		}
		mq.push(1);
		mq.push(2);
		mq.push(3);
		System.out.println("Pull " + mq.pull());
		mq.push(4);
		System.out.println("Pull " + mq.pull());
		mq.push(5);
		while (!mq.isEmpty()) {
			System.out.println("Pull " + mq.pull());
		}

	}

}
