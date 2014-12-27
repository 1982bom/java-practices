/**
 * solution for ploblem 10.4 in Algorithmic Problem Solving Stragies
 */
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import from.hyeoncheol.*;



class MySolver extends Solver<Integer> {
	public MySolver(PrintStream out) {
		super(out);
	}

	public void solve(List<Integer> list) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(list);

		int count = 0;
		Integer i0, i1;
		while (q.size() > 1) {
			i0 = q.poll();
			i1 = q.poll();
			count += i0 + i1;
			q.add(i0 + i1);
		}
		out.println(count);
	}
}

public class StringJoin {
	public static void main(String args[]) {
		IntegerParser parser = new IntegerParser(System.in);
		parser.solve(new MySolver(System.out));
	}
}
