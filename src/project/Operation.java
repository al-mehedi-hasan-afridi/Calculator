package project;

import Exception.NegativeException;
import Exception.ZeroException;

public class Operation {

	public static float add(float a, float b) {
		return a + b;
	}

	public static float substract(float a, float b) {
		return a - b;
	}

	public static float multiply(float a, float b) {
		return a * b;
	}

	public static float divide(float a, float b) throws ZeroException {
		if (b == 0)
			throw new ZeroException("Dividing by zero is not valid");          
		return a / b;
	}

	public static float root(float a) throws NegativeException {
		if (a < 0)
			throw new NegativeException("Negative square root is not valid");
		return (float) Math.sqrt(a);
	}
}
