package examstream.lambdaexp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class BoxedStreamLongStream {

	public static void main(String[] args) {
		List<Long> longs = LongStream.of(1l, 2l, 3l, 4l, 5l).boxed().collect(Collectors.toList());

		System.out.println(longs);

	}

}
