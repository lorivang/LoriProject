package myProj;

public class EditDistance {

	public static int editDist(String a, String b) {
		if (a.length() == 0 || b.length() == 0) {
			// still need to deal with the trailing string of whichever is longer.
			return (Math.max(a.length(), b.length()));  
		}
		if (a.startsWith(b.substring(0, 1))) {
			// same first char, so we can skip that.
			return editDist(a.substring(1), b.substring(1));
		}
		// Now we have 3 choices and we have to decide which to do
		// 1) do a replace
		int rep = 1 + editDist(a.substring(1), b.substring(1));
		// 2) del 1 char from a
		int del = 1 + editDist(a.substring(0), b.substring(1));
		// 3) add 1 char to a
		int add = 1 + editDist(a.substring(1), b.substring(0));
		return Math.min(rep, Math.min(del, add));
	}
	
	public static int replaceCost(String a, String b, int aIndex, int bIndex) {
		return (a.charAt(aIndex) == b.charAt(bIndex) ? 0 : 1);
	}
	
	public static int editDistNonRecursive(String a, String b) {
		// allocate a matrix of int representing the number of transformations at each step.
		int[][] mins = new int[a.length()][b.length()];
		// seed the lower right box.
		mins[a.length()-1][b.length()-1] = replaceCost(a, b, a.length() -1, b.length() -1);
		// seed the bottom row.
		for (int j = b.length() -2; j >= 0; j--) {
			mins[a.length()-1][j] = mins[a.length()-1][j+1] + 1;
		}
		// seed the right column.
		for (int j = a.length() -2; j >= 0; j--) {
			mins[j][b.length() -1] = mins[j+1][b.length()-1] + 1;
		}
		// Now fill in the rest
		for (int i = a.length() -2; i >= 0; i--){
			for (int j = b.length() -2; j >= 0; j--) {
				// 1) do a replace
				int rep = replaceCost(a, b, i, j) + mins[i+1][j+1];
				// 2) del 1 char from a
				int del = 1 + mins[i+1][j];
				// 3) add 1 char to a
				int add = 1 + mins[i][j+1];

				mins[i][j] = Math.min(rep, Math.min(del, add));
			}
		}
		return mins[0][0];
	}
	
	static int myEditDist(char[] a, char[] b) {
		int[][] dpMatrix = new int[a.length + 1][b.length + 1];
		//seed the last row and last column with zeros
		for (int i = 0; i < a.length + 1; i++) {
			dpMatrix[i][b.length] = 0;
		}
		for (int i = 0; i < b.length + 1; i++) {
			dpMatrix[a.length][i] = 0;
		}
		// Starting with bottom right (ignoring seed) for each box, calculate the cost
		for (int i = a.length -1; i >= 0; i--) {
			for (int j = b.length - 1; j >= 0; j--) {
				if (a[i] == b[j]) {
					// same letter, no additional replacement cost, so just carry previous cost.
					dpMatrix[i][j] = dpMatrix[i+1][j+1];
				} else {
					// need to either delete or add or replace a letter here
					dpMatrix[i][j] = 1 + Math.min(dpMatrix[i+1][j+1],Math.min(dpMatrix[i+1][j], dpMatrix[i][j+1]));
				}
			}
		}
		return dpMatrix[0][0];
	}
	
	public static void main(String[] args) {
		String[][] tests = {{"cit", "cat"}, {"cat", "car"},
				{"food","flood"},
		{"abcdefghijklmnop","acefhjlnp"},
		{"dog","cat"},
		};
		for (String[] test : tests) {
			System.out.println("Edit Dist btw " + test[0] + " " + test[1] + " is " + myEditDist(test[0].toCharArray(), test[1].toCharArray()) + " " + editDistNonRecursive(test[0], test[1]));
		}

	}

}
