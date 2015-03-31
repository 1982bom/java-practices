package from.hyeoncheol;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * Parse column x row integers and return list of column integer arrays
 */
public class IntegerMatrixParser extends Parser<Integer[]> {

	private int row, col;

	/**
	 * @row or @col is 0, it will be read from input stream in row-col order
	 */
	public IntegerMatrixParser(InputStream in, int row, int col) {
		super(in);
		this.row = row;
		this.col = col;
	}

	protected List<Integer[]> parseCase() {
		if (row <= 0)
			row = scan.nextInt();
		if (col <= 0) 
			col = scan.nextInt();

		ArrayList<Integer[]> list = new ArrayList<Integer[]>(row);
		for (int i = 0; i < row; i++) {
			Integer[] integers = new Integer[col];
			for (int j = 0; j < col; j++)
				integers[j] = scan.nextInt();
			list.add(integers);
		}
		return list;
	}
}
