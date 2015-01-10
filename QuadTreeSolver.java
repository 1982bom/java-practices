
import java.io.PrintStream;
import java.util.List;
import from.hyeoncheol.StringParser;
import from.hyeoncheol.Solver;

public class QuadTreeSolver extends Solver<String> {
	public QuadTreeSolver(PrintStream out) {
		super(out);
	}

	private void concat(StringBuilder out, String lt, String rt,
						String lb, String rb) {
		out.append("x").append(lb).append(rb).append(lt).append(rt);
	}

	private String take(String in, int offset) {
		if (in.charAt(offset) == 'x') {
			StringBuilder out = new StringBuilder();

			offset += 1;
			String lt = take(in, offset); offset += lt.length(); 
			String rt = take(in, offset); offset += rt.length();
			String lb = take(in, offset); offset += lb.length();
			String rb = take(in, offset);
			concat(out, lt, rt, lb, rb);
			return out.toString();
		} else {
			return String.valueOf(in.charAt(offset));
		}
	}

	public void solve(List<String> list) {
		String out = take(list.get(0), 0);
		this.out.println(out);
	}

	public static void main(String[] args) {
		StringParser parser = new StringParser(System.in);
		parser.solve(new QuadTreeSolver(System.out));
	}
}

