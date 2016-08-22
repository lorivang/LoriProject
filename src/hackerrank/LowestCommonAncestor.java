package hackerrank;

import java.util.Iterator;
import java.util.LinkedList;

import hackerrank.heightOfBinTree.Node;

public class LowestCommonAncestor {
	/* Node is defined as :
	 class Node 
	    int data;
	    Node left;
	    Node right;
	    
	    */
	static Node lca(Node root,int v1,int v2)
    {
		// Make this smarter by realizing this is a BST, so root will be between v1 and v2
		// case 1: both are smaller than root.
		if (root.data > v1 && root.data > v2) {
			return lca(root.left, v1, v2);
		}
		
		// case 2: both are greater than root.
		if (root.data < v1 && root.data < v2) {
			return lca(root.right, v1, v2);
		}
		
		// case 3: one on either side.
		return root;

    }
	
	static Node lca2(Node root,int v1,int v2)
	    {

			LinkedList<Node> v1Path = new LinkedList<>();
			LinkedList<Node> v2Path = new LinkedList<>();
			if (findPath(root, v2, v2Path) && findPath(root, v1, v1Path)) { //found both
				Iterator<Node> v1Iterator = v1Path.iterator();
				Iterator<Node> v2Iterator = v2Path.iterator();
				Node prev = root; // keep track of previous node.  It will be the last common node.
				while (v1Iterator.hasNext() && v2Iterator.hasNext()) {
					Node v1temp = v1Iterator.next();
					if (v1temp.data == v2Iterator.next().data) {
						prev = v1temp;
					} else {
						break;
					}
				}
				return prev;
			}
			return null;	       
	    }

	private static boolean findPath(Node root, int v, LinkedList<Node> vPath) {
		if (root == null) { // not found.
			return false;
		}
		if (root.data == v) { // found it!
			vPath.push(root);
			return true;
		}
		
		if (findPath(root.right, v, vPath) || findPath(root.left, v, vPath)) {
			vPath.push(root);
			return true;
		}
		return false;
		
	}


}
