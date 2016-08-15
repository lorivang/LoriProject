package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseCookies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length);
        for (int i = 0; i < n; i++) {
        	// add to heap aka priority queue
        	pq.add(in.nextInt());
        }
        int counter = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
        	counter++;
        	Integer sum  = pq.remove() + pq.remove() * 2;
        	pq.add(sum);
        }
        if (pq.peek() == null || pq.peek() < k) {
        	counter = -1;
        }
        System.out.println(counter);
		in.close();

    }
}
