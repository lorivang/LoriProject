package hackerrank;

import java.util.Scanner;

/**
 * Given a word , rearrange the letters of to construct another word in such a
 * way that is lexicographically greater than . In case of multiple possible
 * answers, find the lexicographically smallest one among them.
 */
public class BiggerIsGreater {
	static final String NO_ANSWER = "no answer";
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String [] inputs = new String[t];
        for (int i = 0; i < t; i++) {
            inputs[i] = in.next(); 
        }
        in.close();

        for (String s : inputs) {
            System.out.println(LexGreater(s));
        }
}

	private static char[] LexGreater(String s) {
		// TODO Auto-generated method stub
		char[] returnString = s.toCharArray();
		int swapIndex = returnString.length -1;
		for (int i = returnString.length -2; i >= 0; i--) {
			if (returnString[i] < returnString[swapIndex]) {
				char temp = returnString[i];
				returnString[i] = returnString[swapIndex];
				returnString[swapIndex] = temp;
				return returnString;
			}
			if (returnString[i] < returnString[swapIndex] ) {
				swapIndex = i;
			}
			
		}
		return NO_ANSWER.toCharArray();
	}

}
