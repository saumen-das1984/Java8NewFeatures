package examstream.lambdaexp;

import java.util.stream.IntStream;

public class IntStreamExample {
	public static void main(String[] args) {
		IntStream stream4 = IntStream.of(10);
		System.out.println("IntStream.of() : ");
		stream4.forEach(System.out::println);
		IntStream stream3 = IntStream.of(1, 2, 3);
		System.out.println("IntStream.of() : ");
		stream3.forEach(System.out::println);
		IntStream stream2 = IntStream.range(1, 5);
		System.out.println("IntStream.range() : ");
		stream2.forEach(System.out::println);
		IntStream stream1 = IntStream.iterate(0, i -> i + 2).limit(10);
		System.out.println("IntStream.iterate() : ");
		stream1.limit(5).forEach(System.out::println);
		IntStream stream = IntStream.generate(() -> {
			return (int) (Math.random() * 10000);
		});
		System.out.println("IntStream.generate() : ");
		stream.limit(5).forEach(System.out::println);
	}
}
