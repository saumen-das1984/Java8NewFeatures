package examstream.lambdaexp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsDistinct {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
		Stream<Integer> stream = intList.stream();
		stream.forEach(p -> System.out.println(p));
		
	    List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
	    Stream<Integer> stream1 = distinctIntList.stream();
		stream1.forEach(p -> System.out.println(p));
	}

}
