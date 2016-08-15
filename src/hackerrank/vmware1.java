package hackerrank;

import java.util.Scanner;

public class vmware1 {
	
    static String mergeStrings(String a, String b) {

		char[] out = new char[a.length() + b.length()];
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		int shortest = (ac.length < bc.length ? ac.length : bc.length);
		int next = 0;
		for (int i = 0; i < shortest; i++) {
			out[next++] = ac[i];
			out[next++] = bc[i];
		}
		if (ac.length == shortest) {
			for (int j = shortest; j < bc.length; j++) {
				out[next++] = bc[j];
			}
		} else {
			for (int j = shortest; j < ac.length; j++) {
				out[next++] = ac[j];
			}

		}
		return String.valueOf(out);
        }

    public static void main(String[] args) {
    	String a = "abcxxx";
    	String b = "cde";
    	System.out.println(mergeStrings(a,b));
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int arr[] = new int[n];
//        for(int arr_i=0; arr_i < n; arr_i++){
//            arr[arr_i] = in.nextInt();
//        }
//        
//        
//        in.close();
    }
}
