package myProj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



import myProj.MyTestClass.SingleLinkedNode;
import myProj.MyTestClass.SinglyLinkedList;

public class LinkedListTest {

	class Node {
		String data;
		Node next;
	}
	
	public static void main(String[] args) {
		MyTestClass mtc = new MyTestClass();
		MyTestClass.SinglyLinkedList<String> Sll = mtc.new SinglyLinkedList<>();
        String[] test = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        LinkedListTest llt = new LinkedListTest();
        Node head = llt.new Node();
        head.data = test[0];
        Node next = head;
        for (int i = 1; i < test.length; i++) {
        	
        	next.next = llt.new Node();
        	next = next.next;
        	next.data = test[i];
        }
        head = reverse(head);
        Sll.addAll(test);
        MyTestClass.prettyPrint(Sll);
       // Sll.setHead(Reverse(Sll.getHead()));
       // MyTestClass.prettyPrint(Sll);

        SingleLinkedNode<String> node = Sll.getHead();
        SingleLinkedNode<String> save = null;
        while (node.getNext() != null) {
        	if (node.getValue().equals("C")) {
        		save = node;
        	}
        	node = node.getNext();
        }
        // At end of list, make the loop.
        node.setNext(save);
        Sll.setHead(reverseWithLoopBreaking(Sll.getHead()));
        MyTestClass.prettyPrint(Sll);

        //System.out.println("Detected loop starting at " + findLoopStart(Sll.getHead()).getValue());
		MyTestClass.SinglyLinkedList<Character> Sll2 = mtc.new SinglyLinkedList<>();
		String testS = "abcdefghijklm";
        Sll2.addAll((testS.chars().mapToObj(c -> (char)c).toArray(Character[]::new)));
        System.out.println("Detected loop starting at " + (findLoopStart(Sll2.getHead()) == null ? null : findLoopStart(Sll2.getHead()).getValue()));

        System.out.println("find half " + findHalf(Sll2).getValue());
	}

	private static SingleLinkedNode detectLoop(SinglyLinkedList sll) {
        SingleLinkedNode node = sll.getHead();
        Set<SingleLinkedNode> loopDetect = new HashSet<>();
        while (node != null) { 
        	if (!loopDetect.add(node)) {
        		return node;
        	}
        	node = node.getNext();
        }
		return null;
	}

	private static SingleLinkedNode findLoopStart(SingleLinkedNode head) {
		if (head == null) {
			return null;
		}
		// 2 pointers, fast and slow, race around the loop until they meet.
		SingleLinkedNode slow = head;
		SingleLinkedNode fast = head;
		boolean found = false;
		while (!found && fast.getNext() != null && fast.getNext().getNext() != null) { // make sure we have 2 more.
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				found = true;
			}
		}
		if (!found) { // no loop
			return null;
		}
		// Now, back fast up to the head ... head and slow will be equal distance from loopstart.
		fast = head;
		while (slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return slow;
	}
	
	private static SingleLinkedNode findHalf(SinglyLinkedList sll) {
		SingleLinkedNode slow = sll.getHead();
		if (slow == null) {
			return null;
		}
		SingleLinkedNode fast = slow;
		while(fast != null && fast.getNext() != null) {
			fast =  fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}
	
	private static SingleLinkedNode reverseWithLoopBreaking(SingleLinkedNode head) {
		// The behavior is to break the loop at the point where it connects to loopstart.
		SingleLinkedNode loopstart = findLoopStart(head);
		if (loopstart != null) {
			// re-find the previous element.
			SingleLinkedNode prev = loopstart;
			while (prev.getNext() != loopstart) {
				prev = prev.getNext();
			}
			prev.setNext(null);
		}
		
		return (Reverse(head));
	}
	
	private static SingleLinkedNode findFromEnd(SinglyLinkedList sll, int k) {
		// find the kth element from the end of the list.
		SingleLinkedNode fast = sll.getHead();
		SingleLinkedNode slow = fast;
		int count = 1;
		while (fast != null && count < k) {
			fast = fast.getNext();
			count++;
		}
		if (fast == null) {
			return null;  // not enough elements.
		}
		if (fast.getNext() == null) {
			// remove 1st element.
			sll.setHead(slow.getNext());
			return slow;
		}
		// Now slow and fast are k elements apart.
		// look 2 ahead so we can remove the element
		while (fast.getNext().getNext() != null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}
		fast = slow.getNext(); // temp pointer
		slow.setNext(slow.getNext().getNext());
		return fast;
		
	}
	static SingleLinkedNode Reverse(SingleLinkedNode head) {

	    if (head.getNext() == null) {
	        return head;
	    }
	    SingleLinkedNode n = Reverse(head.getNext());
	    head.getNext().setNext(head); 
	    head.setNext(null);
	    return n;
	}
	
	static Node reverse(Node head) {
		if (head.next == null) {
			return head;
		}
		Node temp = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}
}
