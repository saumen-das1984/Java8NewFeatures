package examstream.lambdaexp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class BoxedStreamDoubleStream {

	public static void main(String[] args) {
		List<Double> doubles = DoubleStream.of(1d, 2d, 3d, 4d, 5d).boxed().collect(Collectors.toList());

		System.out.println(doubles);

	}

}
