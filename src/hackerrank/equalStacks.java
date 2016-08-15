package hackerrank;

import java.util.Scanner;

public class equalStacks {
    static SumStack biggest(SumStack a, SumStack b, SumStack c) {
    	if (a.sum > b.sum && a.sum > c.sum) {
    		return a;
    	}
    	if (b.sum > c.sum) {
    		return b;
    	} 
    	return c;
    }
    static boolean equalStacks(SumStack a, SumStack b, SumStack c) {
    	if (a.sum == b.sum && a.sum == c.sum) {
    		return true;
    	}
    	return false;
    }
	
	public static class SumStack {
		public int sum;
		public int[] stack;
		public int top;
        
        SumStack(int[] a, int sum) {
        	this.sum = sum;
        	this.stack = a;
        	top = 0;
        }

		public void pop() {
			sum -= stack[top];
			top++;			
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            sum1 += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            sum2 += h2[h2_i];

        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            sum3 += h3[h3_i];

        }
        
        SumStack a, b, c;
        a = new SumStack(h1, sum1);
        b = new SumStack(h2, sum2);
        c = new SumStack(h3, sum3);
        
        while (!equalStacks(a,b,c)) {
        	SumStack big = biggest(a,b,c);
        	big.pop();
        }
        System.out.println(a.sum);
    }
}
