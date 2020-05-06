package exmfunction.lambdaexp;

import java.util.function.Function;

public class FunctionCompose {
	public static void main(String[] args) {
		Function<Integer, String> converter = (i) -> Integer.toString(i);

		Function<String, Integer> reverse = (s) -> Integer.parseInt(s);
		//Function compose returns a composed function that first applies the before function to its input, and then applies this function to the result. 
		System.out.println(converter.apply(3).length());
		System.out.println(converter.compose(reverse).apply("30").length());
	}
}
