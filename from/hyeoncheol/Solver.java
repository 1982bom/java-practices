package from.hyeoncheol;

import java.io.PrintStream;
import java.util.List;

public abstract class Solver<T> {
	public PrintStream out;

	public Solver(PrintStream out) {
		this.out = out;
	}

	abstract public void solve(List<T> list);
}	

