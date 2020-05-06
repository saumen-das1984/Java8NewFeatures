package examstream.lambdaexp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamList {
	public static void main(String[] args) {
		List<Integer> ints = IntStream.of(1,2,3,4,5).boxed().collect(Collectors.toList());
		System.out.println(ints);
	}
}
