package zenossTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Lori Van Gulick
 *
 */
public class PangramDetector {

	private static final char[] ALLCHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	public String findMissingLetters(String sentence) {
		// First convert the sentence to have only lower case chars.
		String onlyChars = sentence.toLowerCase();
		onlyChars = onlyChars.replaceAll("[^a-z]", "");

		// Sort the array of input chars.
		char[] asChars = onlyChars.toCharArray();
		Arrays.sort(asChars);
		String missingChars = "";
		// For each char in alphabet, determine if it is in the sentence. Skip over dup chars.
		int j = 0;
		for (int i = 0; i < ALLCHARS.length; i++) {
			if (j >= asChars.length) {
				missingChars += ALLCHARS[i];
			} else {
				if (ALLCHARS[i] != asChars[j]) {
					missingChars += ALLCHARS[i];
				}
				// Advance to next unique char in sentence.
				while (++j < asChars.length && ALLCHARS[i] == asChars[j]) {
				}
			}
		}
		return missingChars;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] test = {"The quick brown fox jumps over the lazy dog.",
						 "abcxyz123*&^",
						 ""};
		PangramDetector pd = new PangramDetector();
		for (String s : test) {
			System.out.println(s);
			System.out.println("Returns: \"" + pd.findMissingLetters(s) + "\"" );
		}
	}
}
