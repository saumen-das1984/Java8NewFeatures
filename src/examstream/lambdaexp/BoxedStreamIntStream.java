package examstream.lambdaexp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedStreamIntStream {

	public static void main(String[] args) {
		List<Integer> ints = IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList());
		System.out.println(ints);

		//Stream operations directly
		Optional<Integer> max = IntStream.of(1, 2, 3, 4, 5).boxed().max(Integer::compareTo);
		System.out.println(max);

	}

}
