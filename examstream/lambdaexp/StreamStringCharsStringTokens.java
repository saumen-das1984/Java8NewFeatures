package examstream.lambdaexp;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStringCharsStringTokens {

	public static void main(String[] args) {
		IntStream stream = "12345_abcdefg".chars();
		stream.forEach(p -> System.out.println(p));

		// OR

		Stream<String> streamArray = Stream.of("A$B$C".split("\\$"));
		streamArray.forEach(p -> System.out.println(p));
	}
}
