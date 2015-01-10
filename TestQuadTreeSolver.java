
import junit.framework.TestCase;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;

import from.hyeoncheol.StringParser;
import from.hyeoncheol.StringBufferOutputStream;

public class TestQuadTreeSolver extends TestCase {
	public void testReverse() {
		try {
			StringParser parser = new StringParser(new FileInputStream("QuadTreeSolver.txt"));
			StringBufferOutputStream out = new StringBufferOutputStream();
			QuadTreeSolver solver = new QuadTreeSolver(new PrintStream(out));
			parser.solve(solver);

			String[] expected = {"w", "xwbbw", "xxbwwbbbw", "xxwbxwwxbbwwbwbxwbwwxwwwxbbwb"};
			String[] results = out.toString().split("\n");
			for (int i = 0; i < results.length; i++) {
				assertEquals(expected[i], results[i]);	
			}
		} catch(FileNotFoundException e) {
			assertTrue(false);
		} 
	}
}
