package hackerrank;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KingFourSons {
	
	static Map<Integer, BigInteger> factorialCache = new HashMap<>();
	static BigInteger total = BigInteger.ZERO;
	static final BigInteger FOUR_FACTORIAL = BigInteger.valueOf(4*3*2);
	static final BigInteger MOD_FACTOR = BigInteger.valueOf(10*10*10*10*10*10*10*10*10 + 7);
	
	public static void choose (int[] a, int start, int remaining, int[] result) {
		if (remaining == 0) {
			total = total.add(calcPerms(result));
			return;
		}
		for (int i = start; i < a.length; i++) {
			result[result.length - remaining] = a[i];
			choose(a, i + 1, remaining -1, result);
		}
	}
	
    private static BigInteger calcPerms(int[] result) {
    	BigInteger perms = BigInteger.ONE;
    	for (int i = 0; i < result.length; i++) {
    		if (result[i] < 4) {
    			
    		} else {
    			perms = perms.multiply(fourPerms(result[i]).add(BigInteger.ONE));
    		}
    	}
    	return perms;
	}

	private static BigInteger fourPerms(int i) {
		// TODO Auto-generated method stub
		BigInteger b = factorial(i);
		BigInteger c = factorial(i - 4);
		return (b.divide(c.multiply(FOUR_FACTORIAL)));
	}

	private static BigInteger factorial(int i) {
		if (!factorialCache.containsKey(i)) {
			BigInteger result;
			if (i <= 1) {
				result = BigInteger.ONE;
			} else {
				result = factorial(i-1).multiply(BigInteger.valueOf(i));
			}
			factorialCache.put(i, result);
		}
		return factorialCache.get(i);
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        choose(arr, 0, k, new int[k]);
        System.out.println(total.mod(MOD_FACTOR).intValue());
    }

}
