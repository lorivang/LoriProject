package hackerrank;

public class DoubleLinkedList {
	/*
	 * Insert Node at the end of a linked list head pointer input could be NULL
	 * as well for empty list Node is defined as
	 */
	class Node {
		int data;
		Node next;
		Node prev;
	}

	Node SortedInsert(Node head, int data) {
		Node n = new Node();
		n.data = data;
		if (head == null) {
			return n;
		}
		// see if it's first
		if (head.data > data) {
			n.next = head.next;
			head.prev = n;
			return n;
		}
		Node current = head;
		while (current.next != null && current.next.data < data) {
			current = current.next;
		}

		n.next = current.next; // may be null
		n.prev = current;
		current.next = n;
		return head;
	}

	Node Reverse(Node head) {

		if (head == null) {
			return null;
		}
		Node current = head;
		Node next = current.next;
		while (next != null) {
			current.next = current.prev;
			current.prev = next;
			current = next;
			next = next.next;

		}
		current.next = current.prev;
		current.prev = null;
		return current;
	}
}
