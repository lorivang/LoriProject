package hackerrank;


public class MergeLinkedList {
	/*
	  Merge two linked lists 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
    class Node {
        int data;
        Node next;
     }

	Node MergeLists(Node headA, Node headB) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method 

	    if (headA == null) {
	        return headB;
	    }
	    if (headB == null) {
	        return headA;
	    }
	    Node newHead;

	    if (headA.data < headB.data) {
	        newHead = headA;
	        headA = headA.next;
	    } else {
	        newHead = headB;
	        headB = headB.next;
	    }

	    Node tail = newHead;
	    while (headA != null && headB != null) {
	        if (headA.data < headB.data) {
	            tail.next = headA;
	            headA = headA.next;
	        } else {
	            tail.next = headB;
	            headB = headB.next;
	        }
	        tail = tail.next;
	    }
	    if (headA == null) {
	        tail.next = headB;
	    } else {
	        tail.next = headA;
	    }
	    return newHead;
	}
}
