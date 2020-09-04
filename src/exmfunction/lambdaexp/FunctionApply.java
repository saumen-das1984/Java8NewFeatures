package exmfunction.lambdaexp;

import java.util.function.Function;

public class FunctionApply {
	public static void main(String[] args) {
		Function<Integer, String> converter = (i) -> Integer.toString(i);
		//Function apply applies this function to the given argument.
		System.out.println(converter.apply(3).length());
		System.out.println(converter.apply(30).length());
	}
}
