package collectors.tomap.example;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample1 {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("apple", "banana", "apricot", "orange");
		Map<Character, String> m = s.collect(Collectors.toMap(s1 -> s1.charAt(0), s1 -> s1));
		System.out.println(m);
	}
}
