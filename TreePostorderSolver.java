
/**
 * Solution to display nodes in post-order when pre-order and in-order are given 
 */
import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

import from.hyeoncheol.Parser;
import from.hyeoncheol.Solver;

class IntegerArrayParser extends Parser<Integer[]> {
	public IntegerArrayParser(InputStream in) {
		super(in);
	}

	protected List<Integer[]> parseCase() {
		int count = scan.nextInt();
		ArrayList<Integer[]> list = new ArrayList<Integer[]>(2);
		Integer[] ia = new Integer[count];
		for (int i = 0; i < count; i++) 
			ia[i] = scan.nextInt();
		list.add(ia);
		ia = new Integer[count];
		for (int i = 0; i < count; i++)
			ia[i] = scan.nextInt();
		list.add(ia);
		return list;
	}
}

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
		IntegerArrayParser parser = new IntegerArrayParser(System.in);
		parser.solve(new TreePostorderSolver(System.out));
	}
	
}
