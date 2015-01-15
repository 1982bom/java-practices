package from.hyeoncheol;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

public class GridPlateParser extends Parser<int[][]> {
	public GridPlateParser(InputStream in) {
		super(in);
	}

	protected List<int[][]> parseCase() throws IOException {
		int row = scan.nextInt(), col = scan.nextInt();
		int[][] plate = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				plate[i][j] = scan.nextInt();

		List<int[][]> list = new ArrayList<int[][]>(1);
		list.add(plate);
		return list;
	}
}

