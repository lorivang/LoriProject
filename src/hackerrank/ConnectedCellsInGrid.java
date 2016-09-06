package hackerrank;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Consider a matrix with n rows and m columns, where each cell contains either a  1 or 
 * a 0 and any cell containing a 1 is called a filled cell. Two cells are said to be
 * connected if they are adjacent to each other horizontally, vertically, or
 * diagonally If one or more filled cells are also connected, they form a
 * region. Note that each cell in a region is connected to at least one other
 * cell in the region but is not necessarily directly connected to all the other
 * cells in the region.
 * 
 * Task Given an matrix, find and print the number of cells in the largest
 * region in the matrix. Note that there may be more than one region in the
 * matrix.
 *
 */
public class ConnectedCellsInGrid {
	static class Coords {
		public Coords(int i2, int j2) {
			this.i = i2; this.j=j2;
		}
		int i;
		int j;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a[][] = new int[n][m];
        for(int i=0; i < n; i++){
            for(int j=0; j < m; j++){
            	a[i][j] = in.nextInt();
            }
        }

        System.out.println(findLargestRegion(a));
        in.close();
}
	private static int doFindLargestRegion(int[][] a, int i, int j) {
		int count = 0;
		if (a[i][j] <= 0) { // either already visited, or not set
			return 0;
		}
		count = 1; // for this node
		a[i][j] = -1; // already visited
		int iMin = (i == 0 ? i : i-1);
		int iMax = (i == a.length -1 ? i : i+1);
		int jMin = (j == 0 ? j : j-1);
		int jMax = (j == a[0].length - 1 ? j : j+1);
		
		for (int k = iMin; k <= iMax; k++) {
			for (int l = jMin; l <= jMax; l++) {
				count += doFindLargestRegion(a, k, l);
			}
		}
		return count;
		
	}

	private static int findLargestRegion(int[][] a) {

		int count = 0;
        for(int i=0; i < a.length; i++){
            for(int j=0; j < a[0].length; j++){
            	count = Math.max(doFindLargestRegionNonRecursive(a, i, j), count);
            }
        }
		return count;
	}

	/**
	 * This would be better for large data sets were we might get a stack overflow recursively.
	 */
	private static int doFindLargestRegionNonRecursive(int[][] a, int i, int j) {
		int count = 0;
		if (a[i][j] <= 0) { // either already visited, or not set
			return 0;
		}
		count = 1; // for this node
		a[i][j] = -1; // already visited
		Queue<Coords> queue = new LinkedList<Coords>();
		queue.add(new Coords(i, j));
		while (!queue.isEmpty()) {
			Coords c = queue.remove();
			int iMin = (c.i == 0 ? c.i : c.i - 1);
			int iMax = (c.i == a.length - 1 ? c.i : c.i + 1);
			int jMin = (c.j == 0 ? c.j : c.j - 1);
			int jMax = (c.j == a[0].length - 1 ? c.j : c.j + 1);
			for (int k = iMin; k <= iMax; k++) {
				for (int l = jMin; l <= jMax; l++) {
					if (a[k][l] == 1) {
						a[k][l] = -1; // already visited
						count++;
						queue.add(new Coords(k, l));
					}
				}
			}
		}
		return count;
	}

}
