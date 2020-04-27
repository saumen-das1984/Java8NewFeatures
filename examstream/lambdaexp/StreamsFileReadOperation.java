package examstream.lambdaexp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsFileReadOperation {
	
	private List<String> getPalindrome(Stream<String> stream, int length) {
	    return stream.filter(s -> s.length() == length)
	      .filter(s -> s.compareToIgnoreCase(
	        new StringBuilder(s).reverse().toString()) == 0)
	      .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		String fileName = "D:\\StreamTestData\\Test1.txt";
		StreamsFileReadOperation frOp = new StreamsFileReadOperation();
		try {
			List<String> str = frOp.getPalindrome(Files.lines(Paths.get(fileName)), 5);
			System.out.println("File Data : "+str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
