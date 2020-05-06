package examstream.lambdaexp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamArrayExample {
	public static void main(String[] args) {
		int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();
		System.out.println(Arrays.toString(intArray));
	}
}
