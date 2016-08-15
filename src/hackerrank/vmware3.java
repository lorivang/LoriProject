package hackerrank;

import java.util.Scanner;

public class vmware3 {
	   public static class LinkedListNode{
	        int val;
	        LinkedListNode next;
	    
	        LinkedListNode(int node_value) {
	            val = node_value;
	            next = null;
	        }
	    };
	    
	    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
	        if(head == null) {
	            head = new LinkedListNode(val);
	            tail = head;
	        }
	        else {
	            tail.next = new LinkedListNode(val);
	            tail = tail.next;
	        }
	        return tail;
	    }

	    static LinkedListNode removeNodes(LinkedListNode list, int x) {
	    	LinkedListNode newHead = list;
	    	LinkedListNode prev = null;
	    	LinkedListNode cur = list;
	    	while (cur != null) {
	    		if (cur.val > x) {
	    			// remove it.
	    			if (prev == null) { // at head of list.
	    				newHead = cur.next;
	    			} else {
	    				prev.next  = cur.next;
	    			}
	    		} else {
	    			prev = cur;
	    		}
    			cur = cur.next;	    			

	    	}
			return newHead;


	    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        in.close();

    }
}
