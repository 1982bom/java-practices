
/**
 * Solution to display nodes in post-order when pre-order and in-order are given 
 */
import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

import from.hyeoncheol.Parser;
import from.hyeoncheol.IntegerMatrixParser;
import from.hyeoncheol.Solver;

public class TreePostorderSolver extends Solver<Integer[]> {
	List<Integer> postorder, preorder;

	public TreePostorderSolver(PrintStream out) {
		super(out);
	}

	private void visit(Integer[] inorder, int m, int n) {
		int root = preorder.remove(0);
		if (m == n) {
			postorder.add(root);
			return;
		}
		int i = 0;
		for (i = m; i <= n; i++) {
			if (inorder[i] == root)
				break;
		}
		if (m < i)
			visit(inorder, m, i - 1);
		if (i < n)
			visit(inorder, i + 1, n);
		postorder.add(root);
	}

	public void solve(List<Integer[]> list) {
		preorder = new ArrayList<Integer>(Arrays.asList(list.get(0)));
		Integer[] inorder = list.get(1);
		postorder = new ArrayList<Integer>(inorder.length);

		visit(inorder, 0, inorder.length - 1);
		out.println(Arrays.toString(postorder.toArray()));
	}

	public static void main(String[] args) {
		IntegerMatrixParser parser = new IntegerMatrixParser(System.in, 2, 0);
		parser.solve(new TreePostorderSolver(System.out));
	}
	
}
