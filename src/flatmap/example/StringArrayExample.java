package flatmap.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringArrayExample {
	public static void main(String[] args) {

		/*
		 * In Java 8, Stream can hold different data types, for examples:
		 * 
		 * Stream<String[]> Stream<Set<String>> Stream<List<String>>
		 * Stream<List<Object>>
		 * 
		 * But, the Stream operations (filter, sum, distinct…) and collectors do not
		 * support it, so, we need flatMap() to do the following conversion :
		 * 
		 * Stream<String[]> -> flatMap -> Stream<String> Stream<Set<String>> -> flatMap
		 * -> Stream<String> Stream<List<String>> -> flatMap -> Stream<String>
		 * Stream<List<Object>> -> flatMap -> Stream<Object>
		 * 
		 * How flatMap() works :
		 * 
		 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
		 * 
		 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
		 * 
		 */

		// Using normal map

		String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };

		// Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);

		// filter a stream of string[], and return a string[]?
		Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));

		System.out.println("Normal Map Implementaion");
		stream.forEach(System.out::println);

		// Using flat map

		// Stream<String[]>
		Stream<String[]> temp1 = Arrays.stream(data);

		// Stream<String>, GOOD!
		Stream<String> stringStream = temp1.flatMap(x -> Arrays.stream(x));

		Stream<String> stream1 = stringStream.filter(x -> "a".equals(x.toString()));

		System.out.println("Flat Map Implementaion");
		stream1.forEach(System.out::println);

		// Another way

		Stream<String> stream2 = Arrays.stream(data).flatMap(x -> Arrays.stream(x))
				.filter(x -> "a".equals(x.toString()));

		System.out.println("Flat Map Implementaion Another way");
		stream2.forEach(System.out::println);

	}
}
