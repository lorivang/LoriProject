package myProj;

import java.util.Stack;

/**
 * From Amazon reviews.  Given a bar graph, find the largest contiguous rectangle that can be formed.
 * This actually has nothing to do with bar graphs.  It is just the largest min number that can be taken from a series of numbers.
 * All numbers will be positive.
 *
 */
public class BarGraphArea {

	public static void main(String[] args) {

		int[][] tests = {
				{1,2,3,4,5,6}, {1,4,5,3,3,5},
				{1,1,1,1,1,1,6},
				{6,1,1,1,1}
		};

		for (int[] test : tests) {
			System.out.println(getMaxArea(test, test.length));
		}

	}
	 public static int getMaxArea(int[] arr,int n){
	        Stack<Integer> stack = new Stack<Integer>();
	        int area=0;
	        int max=0;
	        int top=0;
	        int i=0;
	        
	        while(i<n){
	            if(stack.isEmpty() || arr[stack.peek()]<=arr[i])
	                stack.push(i++);
	            else{
	                top = stack.peek();
	                stack.pop();
	                area = arr[top] * (stack.isEmpty() ? i : i-stack.peek()-1);
	                if(max<area)
	                    max = area;
	            }
	        }
	        while(!stack.isEmpty()){
	            top = stack.peek();
	            stack.pop();
	            area = arr[top] * (stack.isEmpty()? i : i-stack.peek()-1);
	            if(max<area)
	                max = area;
	        }
	        return max;
	    }
	    
	private static int findLargest(int[] test) {
		Stack<Integer> maxs = new Stack<>();
		int max = 0;
		int area = 0;
		int top;
		
		for (int i = 0; i < test.length; ++i) {
			if (maxs.isEmpty() || test[i] >= test[maxs.peek()]) {
				maxs.push(i);
			} else {
				while (!maxs.isEmpty() && test[maxs.peek()] > test[i]) {
					top = maxs.pop();
				}
				area = test[i] * (maxs.isEmpty()?i:i-maxs.peek()); 									
			}
			max = Math.max(max, area);			
		}
		while (!maxs.isEmpty()) { //special case?
			top = maxs.pop();
			area = test[top] * (maxs.isEmpty()?test.length:test.length-1-maxs.peek());
			max = Math.max(max, area);
		}
		return max;
	}

}
