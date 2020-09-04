package examstream.lambdaexp;

import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0),
				new Employee(2, "Bill Gates", 200000.0), new Employee(3, "Mark Zuckerberg", 300000.0) };

		Stream<Employee> stream4 = Stream.of(arrayOfEmps);
		System.out.println("Stream.of() : ");
		stream4.forEach(System.out::println);
		
		Stream<Employee> stream5 = Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);
		System.out.println("Stream.of() : ");
		stream5.forEach(System.out::println);
		
		Stream.Builder<Employee> empStreamBuilder = Stream.builder();
		empStreamBuilder.accept(arrayOfEmps[0]);
		empStreamBuilder.accept(arrayOfEmps[1]);
		empStreamBuilder.accept(arrayOfEmps[2]);
		Stream<Employee> empStream = empStreamBuilder.build();
		System.out.println("Stream.builder() : ");
		empStream.forEach(System.out::println);

	}

}
