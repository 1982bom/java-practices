import java.io.*;

public class ParseInt {
	public static int parse(String s) {
		int result = 0, offset;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			result *= 10;
			result += Character.digit(s.charAt(i), 10);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(ParseInt.parse(args[0]));
	}
}
