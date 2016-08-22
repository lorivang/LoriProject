package myProj;

import java.util.HashMap;
import java.util.Map;

public class AmazonQ3 {
	Character firstUnique(char[] a) {
	    Map<Character, Integer> m = new HashMap<>();
	    for (int i = 0; i < a.length; i++) {
	        if (m.containsKey(a[i])) {
	            int value = m.get(a[i]);
	            m.put(a[i], value+1);
	        } else {
	            m.put(a[i], 1);
	        }
	    }
	     for (int i = 0; i < a.length; i++) {
	        if (m.containsKey(a[i])) {
	            int value = m.get(a[i]);
	            if (value == 1) {
	                return a[i];
	            }
	        }
	     }
	     return null;
	}
}
