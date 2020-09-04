package examstream.lambdaexp;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamsFileWriteOperation {

	public static void main(String[] args) {
		String fileName = "D:\\StreamTestData\\Test1.txt";
		String[] words = { "hello", "refer", "world", "level" };

		try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(fileName)))) {
			Stream.of(words).forEach(pw::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
