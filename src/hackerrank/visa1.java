package hackerrank;

import java.util.Stack;

public class visa1 {
	static String[] braces(String[] values) {
		String[] retVal = new String[values.length];
		
		// Find first open brace from start, and last from end
		// Keep count of 3 different kinds of braces .. at end all counts should be 0 if match.
		for (int i = 0; i < values.length; i++) {
			if (doBraces(values[i])) {
				retVal[i] = "YES";
				
			} else {
				retVal[i] = "NO";
			}
		}
		return retVal;
	}

    private static boolean doBraces(String s) {

    	Stack<Character> braceStack = new Stack<>();
    	char[] schar = s.toCharArray();
    	for (Character c : schar) {
    		if (isOpenParen(c)) {
    			braceStack.push(c); 
    		} else {
    			if (!matchBrace(braceStack.pop(), c)) {
    				return false;
    			}
    		}
    	}
    	return (braceStack.isEmpty());
	}

	private static boolean matchBrace(Character open, Character close) {
		// TODO Auto-generated method stub
		if (close == ']') {
			return (open == '[');
		} else if (close == '}') {
			return (open == '{'); 
		} else if (close == ')') {
			return (open == '(');
		}
		return false;
	}

	private static boolean isOpenParen(Character c) {
		// TODO Auto-generated method stub
		return (c == '{' || c == '(' || c == '[');
	}

	public static void main(String[] args) {
		String[] tests = {
    	 "{}[]({})" ,
    	"{[)",
    	"{([()])}"
		};
		String[] out = braces(tests);
		for (String o : out) {
    	System.out.println(o);
		}
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
