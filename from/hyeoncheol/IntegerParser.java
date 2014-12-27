package from.hyeoncheol;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

public class IntegerParser extends Parser<Integer> {
	public IntegerParser(InputStream in) {
		super(in);
	}

	protected List<Integer> parseCase() {
		int count = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>(count);
		for (int i = 0; i < count; i++) 
			list.add(scan.nextInt());
		return list;
	}
}
