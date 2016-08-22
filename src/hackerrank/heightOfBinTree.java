package hackerrank;

import java.util.LinkedList;
import java.util.Queue;

public class heightOfBinTree {
    static class Node {
       int data;
       Node left;
       Node right;
    }
       
    static int highestHeight = 0;

    public void doHeight(Node root, int height) {
    	if (root.left == null && root.right == null) {
    		if (height > highestHeight) {
    			highestHeight = height;
    		}
    		return;
    	}
    	if (root.right != null) {
    		doHeight(root.right, height+1);
    	}
    	if (root.left != null) {
    		doHeight(root.left, height+1);
    	}

    }

    int height(Node root)
    {
    	doHeight(root, 0);
    	return(highestHeight);
    }
    
	static Node Insert(Node root, int value) {
		if (root == null) {
			Node node = new Node();
			node.data = value;
			root = node;
		} else if (root.data > value)
			root.left = Insert(root.left, value);
		else if (root.data < value)
			root.right = Insert(root.right, value);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Queue q = new LinkedList();
	}

}
