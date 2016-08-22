package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;
//Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value . To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:
//
//sweetness Least sweet cookie 2nd least sweet cookie).
//
//He repeats this procedure until all the cookies in his collection have a sweetness .
//You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness . Print if this isn't possible. 
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
