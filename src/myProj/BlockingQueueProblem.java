package myProj;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProblem {

	public static BlockingQueue<Integer> bq;
	static int MAX_SIZE = 5;

	public class Producer implements Runnable {
		int threadNum;

		Producer(BlockingQueue<Integer> queue, int threadNum) {
			this.threadNum = threadNum;
			bq = queue;
		}

		@Override
		public void run() {
			int counter = 1;
			try {
				while (true) {
					Integer next = counter++;
					// put blocks until there's room
					// simulate the production
					Thread.sleep(5); 
					bq.put(next);
					System.out.println("Producer " + threadNum + " : " + next);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class Consumer implements Runnable {
		int threadNum;
		Consumer(BlockingQueue<Integer> queue, int threadNum) {
			bq = queue;
			this.threadNum = threadNum;
		}

		@Override
		public void run() {
			try {
				while (true) {
					// take also blocks until there's something to take.
					System.out.println("Consumer " + threadNum + " : " + bq.take());
					Thread.sleep(10); // simulate the consumption
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(MAX_SIZE);
		BlockingQueueProblem bqp= new BlockingQueueProblem();
		
		for (int i = 0; i < 3; i++) {
			Producer p = bqp.new Producer(queue, i);
			new Thread(p).start();			
		}
		
		for (int i = 0; i < 5; i++) {
			Consumer c = bqp.new Consumer(queue, i);
			new Thread(c).start();			
		}

		// Let the simulation run for, say, 10 seconds = 10 * 1000 milliseconds
        Thread.sleep(10 * 1000);
 
        // End of simulation - shut down gracefully
        System.exit(0);

	}

}
