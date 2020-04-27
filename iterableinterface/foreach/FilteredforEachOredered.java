package iterableinterface.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteredforEachOredered {
	public static void main(String[] args) {
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

		List<String> result = lines.stream() // convert list to stream
				.filter(line -> !"mkyong".equals(line)) // we dont like mkyong
				.collect(Collectors.toList()); // collect the output and convert streams to a List

		result.forEach(System.out::println);
	}
}
