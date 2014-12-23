package from.hyeoncheol;

import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import from.hyeoncheol.Solver;

public abstract class Parser<T> {
	public InputStream		in;
	public Scanner			scan;

	public Parser(InputStream in) {
		this.in = in;
		scan = new Scanner(in);
		scan.useDelimiter("\\s+");
	}

	protected abstract List<T> parseCase() throws IOException;

	public void parseSolve(Solver<T> solver) {
		try {
			int count = scan.nextInt();
			for (int i = 0; i < count; i++) {
				solver.solve(parseCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

