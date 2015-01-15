import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import from.hyeoncheol.Parser;
import from.hyeoncheol.Solver;

public class JumpSolver extends Solver<int[][]> {
	public JumpSolver(PrintStream out) {
		super(out);
	}

	private int jump(int[][] p, int y, int x, int[][] possible) {
		if (y >= p.length || x >= p[0].length) {
			return 0;
		} if (y == p.length-1 && x == p[0].length-1) {
			return 1;
		} else {
			if (possible[y][x] != -1) {
				return possible[y][x];
			} else {
				if (jump(p, y, x + p[y][x], possible) == 1
					|| jump(p, y + p[y][x], x, possible) == 1) {
					possible[y][x] = 1;
					return 1;
				} else {
					possible[y][x] = 0;
					return 0;
				}
			}
		}
	}

	public void solve(List<int[][]> list) {
		int[][] p = list.get(0);
		int[][] possible = new int[p.length][p[0].length];
		for (int i = 0; i < possible.length; i++) {
			Arrays.fill(possible[i], -1);
		}

		out.println(jump(p, 0, 0, possible));
	}

	public static void main(String[] args) {
		GridPlateParser parser = new GridPlateParser(System.in);
		parser.solve(new JumpSolver(System.out));
	}
}
