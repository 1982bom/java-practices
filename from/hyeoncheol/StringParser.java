package from.hyeoncheol;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

public class StringParser extends Parser<String> {
	public StringParser(InputStream in) {
		super(in);
	}

	protected List<String> parseCase() {
		List<String> list = new ArrayList<String>(1);
		list.add(scan.next());
		return list;
	}
}
