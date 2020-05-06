package examstream.lambdaexp;

import java.util.stream.Stream;

public class StreamMap {
	public static void main(String[] args) {
		Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
		.limit(20)
		.map(n -> n[0])
		.forEach(x -> System.out.println(x));
	}
}
