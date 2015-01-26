
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import from.hyeoncheol.Parser;
import from.hyeoncheol.Solver;

class WildcardsParser extends Parser<String> {
	public WildcardsParser(InputStream in) {
		super(in);
	}

	protected List<String> parseCase() {
		List<String> list = new ArrayList<String>();
		String pattern = scan.next();
		list.add(pattern);
		int count = scan.nextInt();
		for (int i = 0; i < count; i++)
			list.add(scan.next());
		return list;
	}
}

class WildcardsSolver extends Solver<String> {
	private int[][] match_table = new int[101][101];

	public WildcardsSolver(PrintStream out) {
		super(out);
	}

	protected int match(String pat, int p0, String str, int s0) {
		if (match_table[p0][s0] != -1)
			return match_table[p0][s0];

		while (p0 < pat.length() && s0 < str.length() &&
				(pat.charAt(p0) == str.charAt(s0) || pat.charAt(p0) == '?')) {
			p0++;
			s0++;
		}

		if (p0 == pat.length()) {
			return (match_table[p0][s0] = (s0 == str.length()? 1 : 0));
		} else if (s0 == str.length()) {
			for (; p0 < pat.length(); p0++) {
				if (pat.charAt(p0) != '*') {
					return (match_table[p0][s0] = 0);
				}
			}
			return (match_table[p0][s0] = 1);
		} else if (pat.charAt(p0) == '*') {
			for (int i = s0; i <= str.length(); i++) {
				if (match(pat, p0+1, str, i) == 1) {
					return (match_table[p0+1][i] = 1);
				}
			}
		} 
		return (match_table[p0][s0] = 0);
	}

	protected boolean match_recursive(String pat, int p0, String str, int s0) {
		while (p0 < pat.length() && s0 < str.length() &&
				(pat.charAt(p0) == str.charAt(s0) || pat.charAt(p0) == '?')) {
			p0++;
			s0++;
		}

		if (p0 == pat.length()) {
			return s0 == str.length();
		} else if (s0 == str.length()) {
			for (; p0 < pat.length(); p0++) {
				if (pat.charAt(p0) != '*')
					return false;
			}
			return true;
		} else if (pat.charAt(p0) == '*') {
			for (int i = s0; i <= str.length(); i++) {
				if (match_recursive(pat, p0+1, str, i))
					return true;
			}
		} 
		return false;
	}

	public void solve(List<String> list) {
		for (int i = 0; i < match_table.length; i++)
			Arrays.fill(match_table[i], -1);

		String pattern = list.remove(0);
		for (String s : list) {
			if (match(pattern, 0, s, 0) == 1)
				out.println(s);
		}
	}

	public static void main(String[] args) {
		WildcardsParser parser = new WildcardsParser(System.in);
		parser.solve(new WildcardsSolver(System.out));
	}
}
