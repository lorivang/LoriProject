package hackerrank;

import java.util.Stack;

import hackerrank.MergeLinkedList.Node;

public class FindMergeNodeClass {
	static /*
	  Insert Node at the end of a linked list 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	
	int FindMergeNodeInPlace(Node headA, Node headB) {
		int count1 = 0, count2  = 0;
		Node a = headA;
		Node b = headB;
		while (a != null) {
			count1++;
			a = a.next;
		}
		while (b != null) {
			count2++;
			b = b.next;
		}
		
		a = headA;
		b = headB;
		// which ever is longer, advance that one until they are same length, then find the first common node.
		if (count1 > count2) {
			for (int i = 0; i < count1-count2; i++) {
				a = a.next;
			}
		} else {
			for (int i = 0; i < count2-count1; i++) {
				b = b.next;
			}
		}
		
		while (a != b) {
			a = a.next;
			b = b.next;
		}
		return a.data;
	}
	
	int FindMergeNode(Node headA, Node headB) {
		int ret = 0;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		Node a = headA;
		Node b = headB;
		while (a != null) {
			s1.push(a);
			a = a.next;
		}
		while (b != null) {
			s2.push(b);
			b = b.next;
		}
		while (!s1.isEmpty() && !s2.isEmpty() && (s1.peek() == s2.peek())) {
			// pop one off of each list until they are no longer equal.
			ret = s1.pop().data;
			s2.pop();
		}
		return ret; 
	}

    public static void main(String[] args) {
    	MergeLinkedList mll = new MergeLinkedList();
		Node n1 = mll.new Node();
		n1.data = 1;
		Node n1b = mll.new Node();
		n1b.data = 1;
		Node n2 = mll.new Node();
		n2.data = 2;
		Node n3 = mll.new Node();
		n3.data = 3;
		n1.next = n2;
		n1b.next = n2;
		n2.next = n3;
		System.out.println(FindMergeNodeInPlace(n1, n1b));
	}
}
