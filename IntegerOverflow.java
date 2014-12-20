
public class IntegerOverflow {
	public static int add(int i0, int i1) throws ArithmeticException {
		if (i1 > 0 && i0 > Integer.MAX_VALUE - i1)
			throw new ArithmeticException("integer overflow");
		else if (i1 < 0 && i0 < Integer.MIN_VALUE - i1)
			throw new ArithmeticException("integer overflow");
		return i0 + i1;
	}

	public static void main(String[] args) {
		//add(Integer.MAX_VALUE, 1);
		add(Integer.MIN_VALUE, -1);
	}
}
