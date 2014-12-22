import junit.framework.TestCase;

public class TestIntegerOverflow extends TestCase {
	public void testAdd() {
		try {
			IntegerOverflow.add(Integer.MAX_VALUE, 1);
			assertTrue(false);
		} catch (ArithmeticException e) {}
		try {
			IntegerOverflow.add(Integer.MIN_VALUE, -1);
			assertTrue(false);
		} catch (ArithmeticException e) {}
	}

	public void testSub() {
		try {
			IntegerOverflow.sub(Integer.MIN_VALUE, 1);
			assertTrue(false);
		} catch (ArithmeticException e) {}
		try {
			IntegerOverflow.sub(Integer.MAX_VALUE, -1);
			assertTrue(false);
		} catch (ArithmeticException e) {}
	}

	public void testMulti() {
		try {
			IntegerOverflow.multi(Integer.MIN_VALUE, Integer.MIN_VALUE);
			assertTrue(false);
		} catch (ArithmeticException e) {}
		try {
			IntegerOverflow.multi(Integer.MIN_VALUE, Integer.MAX_VALUE);
			assertTrue(false);
		} catch (ArithmeticException e) {}
	}

	public void testDiv() {
		try {
			IntegerOverflow.div(Integer.MIN_VALUE, -1);
			assertTrue(false);
		} catch (ArithmeticException e) {}
	}
}

