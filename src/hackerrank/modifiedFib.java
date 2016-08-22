package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Modified fibonacci is ti+2 = ti + (ti+1)sqrd
 * @author Lori
 *
 */
public class modifiedFib {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t0 = in.nextInt();
        int t1 = in.nextInt();
        int n = in.nextInt();
        BigInteger first = BigInteger.valueOf(t0);
        BigInteger second = BigInteger.valueOf(t1);
        BigInteger tn = BigInteger.ZERO; // answer
        for (int i = 2; i < n; i++) {  // i is just a counter. 
        	tn = first.add(second.multiply(second));
        	first = second;
        	second = tn;
        }
        System.out.println(tn);
		in.close();

    }
}
