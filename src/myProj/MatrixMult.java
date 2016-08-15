package myProj;

public class MatrixMult {

	public static void main(String[] args) {
		int[][] A = {{1, 2, 3}, {4, 5, 6}};
		int[][] B = {{1, 2}, {2, 4}, {6, 7}};

		int[][] result = matrixMult(A,B);
		prettyPrint(result);
		diagPrint(A);
		diagPrint(B);
		diagPrint(result);
	}

	public static void prettyPrint(int[][] result) {
		System.out.println("Array output:");
		for (int[] row : result) {
			for (int i : row) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}
	
	private static void diagPrint(int[][] result) {
		System.out.println("Array output diagonal:");
		for (int i = result.length-1; i >= 0; i--) {
			for (int j = (i==result.length-1 ? 0 : result[i].length-1); j < result[0].length; j++) {
				int k = i; int l = j;
				do {
					System.out.print(result[k][l] + " ");
				} while (--k >=0 && --l >=0);
			}
		}		
		System.out.println();
	}

	private static int[][] matrixMult(int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			throw new IllegalArgumentException("Bad array dimentions; length of a must equal height of b");
		}
		int[][] result = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) { // for each row of a
			for (int j = 0; j < b[i].length; j++) { // for each col of b
				for (int k = 0; k < a[0].length; k++) { // for each col of a
					result[i][j] += (a[i][k] * b[k][j]);
				}
			}
		}
		return result;
	}

}
