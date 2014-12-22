
public class IntegerOverflow {
	public static int add(int i0, int i1) throws ArithmeticException {
		if (i1 > 0 && i0 > Integer.MAX_VALUE - i1)
			throw new ArithmeticException("integer overflow");
		else if (i1 < 0 && i0 < Integer.MIN_VALUE - i1)
			throw new ArithmeticException("integer overflow");
		return i0 + i1;
	}

	public static int sub(int i0, int i1) throws ArithmeticException {
		if (i1 > 0 && i0 < Integer.MIN_VALUE + i1)
			throw new ArithmeticException("integer overflow");
		else if (i1 < 0 && i0 > Integer.MAX_VALUE + i1)
			throw new ArithmeticException("integer overflow");
		return i0 - i1;
	}

	public static int multi(int i0, int i1) throws ArithmeticException {
		long l = (long)i0 * i1;
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE)
			throw new ArithmeticException("integer overflow");
		return i0 * i1;
	}

	public static int div(int i0, int i1) throws ArithmeticException {
		if (i0 == Integer.MIN_VALUE && i1 == -1)
			throw new ArithmeticException("integer overflow");
		return i0 / i1;
	}

	public static void main(String[] args) {
	}
}
