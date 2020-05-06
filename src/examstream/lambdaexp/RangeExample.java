package examstream.lambdaexp;

import java.util.stream.IntStream;

public class RangeExample {

	public static void main(String[] args) {
		//Range
		//Returns a sequential ordered int stream from startInclusive (inclusive) to endExclusive (exclusive) by an incremental step of 1.
        IntStream stream = IntStream.range(5, 10); 
        System.out.println("IntStream.range() : ");
        stream.forEach(System.out::println);
         
        //Closed Range
        //Returns a sequential ordered int stream from startInclusive (inclusive) to endInclusive (inclusive) by an incremental step of 1.
        IntStream closedRangeStream = IntStream.rangeClosed(5, 10);
        System.out.println("IntStream.rangeClosed() : ");
        closedRangeStream.forEach(System.out::println);

	}

}
