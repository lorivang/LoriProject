package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ou are given a tree (a simple connected graph with no cycles). The tree has nodes numbered from to .

Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of the forest contains an even number of vertices.

Input Format
The first line of input contains two integers and . is the number of vertices, and is the number of edges.
The next lines contain two integers and which specifies an edge of the tree.

Output Format

Print the number of removed edge.
 *
 *NOTE: my implementation makes a lot of assumptions about the input.  i.e. that 1 is always the root.  So essentially, my array is the BFS result of navigating the tree.
 *That's why starting from the end of the array (leaves) works here and in hackerrank.
 */
public class EvenTree {
	
	static class Data {
		List<Integer> edges;
		boolean even;
		
		public Data() {
			edges = new ArrayList<>();
			even = false;
		}
	}
	
    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    Data tree[] = new Data[n];
    for (int i = 0; i < n; i++) {
    	tree[i] = new Data();
    }
    for(int arr_i=0; arr_i < m; arr_i++){
        int vert = in.nextInt();
        int root = in.nextInt();
        tree[root-1].edges.add(vert);
    }
    // Now calculate the even bit
    int evens = 0;
    for (int i = n-1; i >= 0; i--) {
    	int odds = 0;
    	for (Integer j : tree[i].edges) {
    		odds += ((tree[j-1].even==true) ? 0 : 1);
    	}
    	tree[i].even = odds % 2 == 1;
    	if (tree[i].even) evens++;
    }
    // Finally find the max splits
    // number of evens -1
    System.out.println(evens-1);
}

	private static void printEven(Data[] tree) {
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i].even + " ");
			
		}
		
	}
}

