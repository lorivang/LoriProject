package myProj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StringTest {

	// Given a string containing a sentence, return an array of alphabet (in order) that were not found in the sentence.  
	public static void main(String[] args) {
		String test0 = "";
        System.out.println(reverseInPlace(""));
		if (args.length > 0) {
			test0 = args[0];
		}
		
		String test = "This is my test string, it doesn't contain all chars.";
		System.out.println(panagramDetector(test));
		String[] tests = {"this is my test", "ababab", "abcdef", "a", "aaaaabaaaaa" };
		for (String t : tests) {
		char[] removeDupStr = removeDups(t.toCharArray());
		System.out.println(removeDupStr);
		System.out.println(removeDupsSet(t.toCharArray()));
		}
	}

	private static String reverseInPlace(String s) {
		// swapping
		char[] rev = s.toCharArray();
		for (int i = 0; i < rev.length/2; i++) {
			char temp = rev[i];
			rev[i] = rev[rev.length -1 - i];
			rev[rev.length -1 - i] = temp;
		}
		return (String.valueOf(rev));
	}
	
	private static String AllChars = "abcdefghijklmnopqrstuvwxyz";
	protected static String panagramDetector(String test) {
		// return an array of alphabet (in order) that were not found in the input.
		String lowerTest = test.toLowerCase();
		StringBuffer returnChars = new StringBuffer();
		for (char c : AllChars.toCharArray()) {
			if (lowerTest.indexOf(c) < 0) {
				returnChars.append(c);
			}
		}
		return returnChars.toString();
	}
	
	protected static List<Character> removeDupsSet(char[] input) {
	    List<Character> noDups = new ArrayList<>();
	    Set<Character> set = new HashSet<>();
	    for (char c : input) {
	    	set.add(c);
	    }
	    noDups.addAll(set);
	    return  noDups;
	}

	protected static char[] removeDups(char[] input) {
		if (input == null){
			return null;
		}
		if (input.length == 1) {
			return input;
		}
		
		int tail = 1;  // first possible dup
		// for each char in the input
		for (int i = 1; i < input.length; ++i) {
			// determine if we've seen the char at i already
			int j;
			for (j = 0; j < tail && (input[j] != input[i]); ++j) {
			}
			// if we got to the tail without seeing the letter, 
			// Copy the letter to the tail position and advance the tail.
			if (j == tail) {
				input[tail] = input[i];
				tail++;
			}
		}
		return (Arrays.copyOf(input, tail));
//		for (int i = tail; i < input.length; i++) {
//			input[i] = 0;  // clear out remaining chars.
//		}
//		Arrays.copyOf(input, tail);
//		return input;
	}
	
	protected static boolean palindromChecker(String input) {
		// Eliminate white space and punctuation
		String onlyChars = input.toLowerCase();
		onlyChars = onlyChars.replaceAll("\\W", "");
		System.out.println("adjusted input : " + onlyChars);

		// Find the middle of the string.
		int midpoint = onlyChars.length() / 2;  // round down for odd length?
		for (int i = 0; i < midpoint; i++) {
			if (onlyChars.charAt(i) != onlyChars.charAt(onlyChars.length() -1 -i)) {
				System.out.println("Found difference at i = " + i);
				return false;
			}
		}
		System.out.println("Palindrome found!");
		return true;
	}
	
	protected static String palindromGenerator(int len) {
		char[] pal = new char[len];
		double mid = Math.ceil(len/2);
		Random rand = new Random();
		// generate first half.
		for (int i = 0; i <= mid; i++) {
			pal[i] = (char) (rand.nextInt(26) + 'a');
		}
		// reverse first half
		for (int j = len-1; j > len/2 - 1; j--) {
			pal[j] = pal[len - 1 - j];
		}
		return String.valueOf(pal);
	}
	
	protected static String palindromGenerator(String s) {
		return (s + doPalGen(s));
	}
	
	protected static String doPalGen(String s) {
		if (s.length() == 1) {
			return s;
		} else {
			return (doPalGen(s.substring(1)) + s.charAt(0));
		}

	}
	
	protected static boolean scramble(String source, String test) {
		// return true if source has all the chars in test.
		int[] allChars = new int[256];  // will count the number of occurrences in source
		char[] temp = source.toCharArray();
		for (char c : temp) {
			allChars[c]++;
		}
		temp = test.toCharArray();
		for (char c : temp) {
			if (allChars[c] <= 0) {
				return false;
			}
			allChars[c]--;
		}
		return true;
	}
	
	protected static String commonPrefix(String... strings) {
		String prefix = null;
		// first find the shortest string ... that is the max possible prefix.
		String shortestString = strings[0];
		for (String s : strings) {
			if (s.length() < shortestString.length()) {
				shortestString = s;
			}
		}
		
		// Now find common prefix among all strings.
		int charIndex = 0;
		boolean done = false;
		while (charIndex < shortestString.length() && !done) {
		for (String s : strings) {
			if (shortestString == s) { //skip shortest
				continue;
			}
			if (s.charAt(charIndex) != shortestString.charAt(charIndex)) {
				done = true;
				break;
			}
			
		}
		if (!done) {
			charIndex++;
		}
		}
		return shortestString.substring(0,charIndex);
		
	}
}
