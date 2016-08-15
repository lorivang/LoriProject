package hackerrank;

import java.util.Scanner;

public class DataCompression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        char[] cs = s.toCharArray();
        StringBuffer ret = new StringBuffer(s.length()); // max length
        for (int i = 0; i < s.length(); i++) {
        	int charcount = 1;
        	while (i+1 < s.length() && cs[i] == cs[i+1]) {
        		charcount++;
        		i++;
        	}

        	ret.append(cs[i]);
        	if (charcount != 1) {
        		ret.append(charcount);
        	}
        }
        System.out.println(ret);
    }
}
