package hackerrank;




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

    	if (s.length() == 0) {
    		return true;
    	}
    	if (s.length() == 1) {
    		return false;
    	}
    	int endindex = 0;
    	if (s.charAt(0) == '(') {
    		endindex = s.lastIndexOf(')');
    	} else if (s.charAt(0) == '{') {
    		endindex = s.lastIndexOf('}');
    	} else if (s.charAt(0) == '[') {
    		endindex = s.lastIndexOf(']');
    	} 
    	if (endindex == -1) {
    		return false;
    	}
    	// reached end, only do the first part.
    	if (endindex >= s.length()-1) {
    		return (doBraces(s.substring(1, endindex)));
    	} 
    	return (doBraces(s.substring(1, endindex)) && doBraces(s.substring(endindex+1)));
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
