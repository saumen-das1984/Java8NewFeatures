package examstream.lambdaexp;

import java.util.Date;
import java.util.stream.Stream;

public class StreamGenerate {

	public static void main(String[] args) {
		Stream<Date> stream = Stream.generate(() -> {
			return new Date();
		});
		stream.limit(1).forEach(p -> System.out.println(p));
	}

}
