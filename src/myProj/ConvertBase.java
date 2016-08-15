package myProj;

public class ConvertBase {

	static int convertToBase10(String source, int oldbase) {
		int retVal = 0;
		for (int i = 0; i < source.length(); i++) {
			// 
			int dig = Character.getNumericValue(source.charAt(i));
			retVal += dig * (Math.pow(oldbase, source.length() -1 -i));
		}
		return retVal;
	}
	
	static String convertFromBase10(String source, int newbase) {
		String retVal = "";
		int asInt = Integer.valueOf(source);
		retVal = String.valueOf(asInt % newbase); // least significant digit.
		asInt -= asInt % newbase;
		while (asInt != 0) {
			asInt = asInt/newbase;

			int remainder = asInt % newbase;
			retVal = remainder + retVal;
			asInt -= remainder;
		}
		return retVal;
	}
	
	static String convertToBase(String source, int oldbase, int newbase) {
		int retVal = convertToBase10(source, oldbase);
		return convertFromBase10(String.valueOf(retVal), newbase);
	}
	
	
	public static void main(String[] args) {
		String [] tests = {"10", "17", "0", "1234", "777", "4"};
		for (String test: tests) {
			int base10= convertToBase10(test, 8);
			System.out.println("Octal " + test + " == Decimal " + base10);
			System.out.println("Decimal " + base10 + " == Octal " + convertFromBase10(String.valueOf(base10), 8));
			System.out.println("Octal " + test + " == Binary " + convertToBase(test, 8, 2));
		}

	}

}
