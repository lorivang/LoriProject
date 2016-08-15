package myProj;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTestTest {

	private static final String[] testStrings = {
			"The quick brown fox jumps over the lazy dog.",
			"Simple test String",
			"Contains numbers 2389 8928374 829374 and punctuation (*^#@#<>:",
			"",
			"abcdefghijklmnopqrstuvwxyz",
			"Evil olive",
			"A man, a plan, a canal, Panama!",
			"Ma'dam, I'm Adam.",
			"aa",
			"aba",
			"abca"
	};
	
	@Test
	public void testScramble() {
		System.out.println(StringTest.scramble("wow", "ow"));
		System.out.println(StringTest.scramble("ow", "wow"));
		System.out.println(StringTest.scramble("3980fmlskdajaLKKLKJLKJ23298SSS*(%&^%", "(S^"));
	}
	
	@Test
	public void testTestForChars() {
		for (String s : testStrings) {
			prettyPrint(s, StringTest.panagramDetector(s));
		}
	}

	@Test
	public void testCommonPrefix() {
		String[] input = { "abcdef", "homewrecker", "hope", "home", "hommie", "homework"};
		System.out.println(StringTest.commonPrefix(input));
	}
	
	private void prettyPrint(String s, String s2) {
		prettyPrint(s, s2.toCharArray());		
	}

	@Test
	public void testPalindromChecker() {
		for (String s : testStrings) {
			System.out.println("Result of \"" + s + "\" is " + StringTest.palindromChecker(s));
		}		
	}
	
	private void prettyPrint(String test, char[] notInString) {
		System.out.println("Input string : \"" + test + "\"");
		System.out.print("Chars not in string : ");
		for (char c : notInString) {
			System.out.print(" " + c);
		}
		System.out.println();
	}

}
