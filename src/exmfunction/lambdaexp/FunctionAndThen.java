package exmfunction.lambdaexp;

import java.util.function.Function;

public class FunctionAndThen {
	public static void main(String[] args) {
		Function<Integer, String> converter = (i) -> Integer.toString(i);

		Function<String, Integer> reverse = (s) -> Integer.parseInt(s);
		//Function andThen returns a composed function that first applies this function to its input, and then applies the after function to the result. 
		System.out.println(converter.apply(3).length());
		System.out.println(converter.andThen(reverse).apply(30).byteValue());
	}
}
