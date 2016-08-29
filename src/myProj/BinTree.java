package myProj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myProj.AmazonQ2.Node;

/**
 * create bin search tree from sorted array
 *
 */
public class BinTree {

	public static class Pair<T> {
		T max;
		T min;
		
		Pair(T a, T b) {
			this.max = a;
			this.min = b;
		}
	}
	
	public static AmazonQ2 q2 = new AmazonQ2();
	public static BinTree bt = new BinTree();
	public static final Pair<Integer> badPair = new Pair<Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE);
	public static Node bSTFromSortedArray(int[] a, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = start + (end - start) / 2;
		
		Node n = q2.new Node();
		n.data = a[mid];
		n.left = bSTFromSortedArray(a, start, mid-1);
		n.right = bSTFromSortedArray(a, mid+1, end);
		return n;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		int[] b = {2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		Node head = bSTFromSortedArray(a, 0, a.length -1);

		System.out.println(inOrder(head).toString());
		System.out.println(head.data + " " + checkBSTNoRecursion(head));
	}
	
    static boolean checkBSTNoRecursion(Node root) {
    	List<Integer> a = inOrder(root);
    	int min = a.remove(0);
    	for (Integer i : a) {
    		if (i <= min) {
    			return false;
    		}
    		min = i;
    	}
    	return true;
    }
	

    static boolean checkBST(Node root) {
        Pair<Integer> p = verifyBST(root);
        return (p != badPair);
    }
	
	private static Pair<Integer> verifyBST(Node head) {
		if (head == null) {
			return null;
		}
		if (head.left != null && head.left.data >= head.data) {
			return badPair;
		}
		if (head.right != null && head.right.data <= head.data) {
			return badPair;
		}
		int max, min;
		Pair<Integer> l = verifyBST(head.left);
		if (l != null && l.max >= head.data) {
			return badPair;
		}
		
		Pair<Integer> r = verifyBST(head.right);
		if (r != null && r.min <= head.data) {
			return badPair;
		}

		max = Math.max((l == null ? head.data : l.max), (r == null ? head.data : r.max));
		min = Math.min((l == null ? head.data : l.min), (r == null ? head.data : r.min));
		return (new Pair<Integer>(max, min));

	}

	static List<Integer> inOrder(Node root) {
		List<Integer> ret;
		if (root.left == null) {
			ret =  new ArrayList<Integer>();
			ret.add(root.data);
			return ret;
		}
		ret = inOrder(root.left);
		ret.add(root.data);
		ret.addAll(inOrder(root.right));
		return ret;
		
	}
}
