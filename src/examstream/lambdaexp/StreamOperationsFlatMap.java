package examstream.lambdaexp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsFlatMap {
	public static void main(String[] args) {
		List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"),
				Arrays.asList("Mark", "Zuckerberg"));

		List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());
		
		Stream<String> stream = namesFlatStream.stream();
		stream.forEach(System.out::println);
	}
}
