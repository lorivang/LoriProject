package myProj;

public class AmazonQ2 {
	class Node {
	    int data;
	    Node left;
	    Node right;
	}

	boolean compTrees(Node head1, Node head2) {
	    if (head1 == null && head2 == null) {
	        return true;
	    }
	    if ((head1 == null && head2 != null) || (head2 == null && head1 != null)) {
	        return false;
	    }
	    if (head1.data != head2.data) {
	        return false;
	    }
	    return( compTrees(head1.left, head2.left) && compTrees(head1.right, head2.right));
	}
}
