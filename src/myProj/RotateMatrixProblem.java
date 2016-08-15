package myProj;

import java.util.Arrays;

public class RotateMatrixProblem {

	
	public int[][] rotate90clockwise(int[][] myMatrix) {
		int rowLength = myMatrix[0].length;
		int colLength = myMatrix.length;
		int[][] returnMatrix = new int[rowLength][colLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				returnMatrix[i][j] = myMatrix[colLength -1 -j][i];
			}
		}
		return returnMatrix;
	}
	
	public void rotateInPlace(int[][] myMatrix) {
		// need to do a 4-way swap.
		// only works if depth==breadth
		int rowLength = myMatrix[0].length;
		int colLength = myMatrix.length;
		if (rowLength != colLength) {
			throw new RuntimeException("bad dimensions");
		}
		for (int i = (rowLength/2) ; i >=0; i--) {
			doRotateInPlace(myMatrix, i, rowLength -1 -i);
		}	
	}

	private void doRotateInPlace(int[][] myMatrix, int start, int last) {
		for (int j = start; j < last; j++) {
			int offset = j-start;
			int temp = myMatrix[start][j];
			myMatrix[start][j] = myMatrix[last-offset][start];
			myMatrix[last-offset][start] = myMatrix[last][last - offset];
			myMatrix[last][last - offset] = myMatrix[j][last];
			myMatrix[j][last] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[][] myMatrix = {{1,2,3,4,0},{5,6,7,8,1},{9,10,11,12,2},{13,14,15,16,3}, {17,18,19,20,21}};
		MatrixMult.prettyPrint(myMatrix);
		RotateMatrixProblem rmp = new RotateMatrixProblem();
		MatrixMult.prettyPrint(rmp.rotate90clockwise(myMatrix));
		rmp.rotateInPlace(myMatrix);
		MatrixMult.prettyPrint(myMatrix);

	}

}
