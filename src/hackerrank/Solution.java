package hackerrank;

import java.util.Scanner;

public class Solution {


    static int solveMeFirst(int a, int b) {
      // Hint: Type return a+b; below
      return a + b;
   }

   
// public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a;
//        a = in.nextInt();
//        int b;
//        b = in.nextInt();
//        int sum;
//        sum = solveMeFirst(a, b);
//        System.out.println(sum);
//   }
 public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int arr[] = new int[n];
     int p =0;
     int neg = 0;
     int z = 0;

     for(int arr_i=0; arr_i < n; arr_i++){
         arr[arr_i] = in.nextInt();
         if (arr[arr_i] < 0){
             neg++;
         }else if (arr[arr_i] > 0){
             p++;
         } else{
            z++; 
         }

     }
     System.out.printf("%.6f %n", (double)p/n);
     System.out.println(neg/n);
     System.out.println(z/n);
     
     
 }
}
