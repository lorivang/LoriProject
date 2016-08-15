package hackerrank;

import java.util.LinkedList;
import java.util.Queue;

public class heightOfBinTree {
    class Node {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Queue q = new LinkedList();
	}

}
