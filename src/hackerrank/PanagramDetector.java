package hackerrank;

import java.util.Scanner;

public class PanagramDetector {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String k = in.nextLine();
        final String AllChars = "abcdefghijklmnopqrstuvwxyz";
   		String lowerTest = k.toLowerCase();
        String out = "pangram";
		for (char c : AllChars.toCharArray()) {
			if (lowerTest.indexOf(c) < 0) {
                out = "not pangram";
                break;
            }
        }
        System.out.println(out);
        in.close();
        
    }

}
