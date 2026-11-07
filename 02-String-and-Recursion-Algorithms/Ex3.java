/**
 * Solution for Assignment 3 - Introduction to Computer Science.
 * String manipulation algorithms and recursive mathematical operations.
 */
public class Ex3 {

	public static void main(String[] args) {
		// Quick verification tests
		System.out.println("Valid password ('Pass123!'): " + validPassword("Pass123!"));
		System.out.println("Reversed sentence: " + sentence("Hello world from Java"));
		System.out.println("Can form 'abc' from 'a1b2c3': " + deletions("a1b2c3", "abc"));
		System.out.println("Integer division (17 / 5): " + divide(17, 5));
	}

	/**
	 * Validates a password based on length, digits, special characters, and absence of spaces.
	 * Criteria:
	 * - At least 6 characters long
	 * - Contains no spaces
	 * - Contains at least one digit ('0'-'9')
	 * - Contains at least one special character ('%', '$', '#', '@', '!')
	 * 
	 * @param s - the password string to validate.
	 * @return true if the password meets all criteria, false otherwise.
	 */
	public static boolean validPassword(String s) {
		if (s == null || s.length() < 6) {
			return false;
		}
		
		int numberCount = 0;
		int signCount = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if (ch == ' ') {
				return false;
			}
			if (ch >= '0' && ch <= '9') {
				numberCount++;
			} else if (ch == '%' || ch == '$' || ch == '#' || ch == '@' || ch == '!') {
				signCount++;
			}
		}
		
		return numberCount > 0 && signCount > 0;
	}

	/**
	 * Reverses the order of words in a given sentence.
	 * 
	 * @param s - the input sentence with words separated by spaces.
	 * @return a new string with the words in reverse order.
	 */
	public static String sentence(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		String[] arr = s.split(" ");
		StringBuilder ans = new StringBuilder(arr[arr.length - 1]);
		
		for (int i = arr.length - 2; i >= 0; i--) {
			ans.append(" ").append(arr[i]);
		}
		return ans.toString();
	}

	/**
	 * Checks whether string 't' can be obtained by deleting zero or more characters from string 's'
	 * (i.e., checks if 't' is a subsequence of 's').
	 * 
	 * @param s - the source string.
	 * @param t - the target string.
	 * @return true if 't' is a subsequence of 's', false otherwise.
	 */
	public static boolean deletions(String s, String t) {
		if (t == null || s == null || t.length() > s.length()) {
			return false;
		}
		if (t.isEmpty()) {
			return true;
		}
		
		int i = 0, j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				j++;
				if (j == t.length()) {
					return true;
				}
			}
			i++;
		}
		return false;
	}

	/**
	 * Performs integer division (a / b) recursively using repeated subtraction.
	 * 
	 * @param a - the dividend (non-negative integer).
	 * @param b - the divisor (positive integer).
	 * @return the quotient of a divided by b, or 0 if b is 0.
	 */
	public static int divide(int a, int b) {
		if (b == 0 || a < b) {
			return 0;
		}
		return divide(a - b, b) + 1;
	}
}