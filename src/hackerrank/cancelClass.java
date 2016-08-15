package hackerrank;

import java.util.Scanner;

public class cancelClass {

    public static boolean cancel(int[] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
                if (a[i] <= 0) {
                    count++;
                    if (count >= k) {
                        return false;
                    }
                }

        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            int count = 0;
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            System.out.println(cancel(a,k) ? "YES" : "NO");
        }
    }
}
