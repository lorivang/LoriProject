package hackerrank;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class MyRegexIPAddr {
	
	public static class myRegex {

		 String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
		 public String pattern = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String IP = in.next();
			System.out.println(IP.matches(new myRegex().pattern));
		}

	}
}
