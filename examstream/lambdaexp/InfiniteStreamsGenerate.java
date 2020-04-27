package examstream.lambdaexp;

import java.util.stream.Stream;

public class InfiniteStreamsGenerate {

	public static void main(String[] args) {
		Stream.generate(Math::random).limit(5).forEach(System.out::println);

	}

}
