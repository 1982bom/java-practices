
import java.io.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import from.hyeoncheol.Solver;

/**
 * solution for Alogrithm Problems Solving Strategies, first volume  10.2
 */

class LunchBox {
	public int mealTime, heatupTime;
}

class MySolver extends Solver<LunchBox> {
	public MySolver(PrintStream out) {
		super(out);
	}

	public void solve(List<LunchBox> list) {
		Collections.sort(list, new Comparator<LunchBox>() {
			public int compare(LunchBox l0, LunchBox l1) {
				return l0.mealTime == l1.mealTime ? 0 : (
						l0.mealTime < l1.mealTime ? 1 : -1);
			}
		});
		int t = 0, i;
		for (i = 0; i < list.size(); i++)
			t += list.get(i).heatupTime;
		t += list.get(i-1).mealTime;
		out.println(t);
	}
}

class MyParser extends Parser<LunchBox> {
	public MyParser(InputStream in) {
		super(in);
	}

	List<LunchBox> parseCase() throws IOException {
		int count = scan.nextInt();
		ArrayList<LunchBox> list = new ArrayList<LunchBox>(count);
		for (int i = 0; i < count; i++) {
			LunchBox box = new LunchBox();
			box.heatupTime = scan.nextInt();
			list.add(box);
		}
		for (int i = 0; i < count; i++)
			list.get(i).mealTime = scan.nextInt();
		return list;
	}
}

public class HeatLunchBox {
	public static void main(String[] args) {
		MyParser parser = new MyParser(System.in);
		parser.parseSolve(new MySolver(System.out));
	}
}
