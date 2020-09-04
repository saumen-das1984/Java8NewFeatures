package exmfunction.lambdaexp;

import java.util.function.Function;

public class FunctionIdentity {
	public static void main(String[] args) {
		Function<Integer, Integer> id = Function.identity();
		//Function identity returns a function that always returns its input argument.
		System.out.println(id.apply(3));

	}
}
