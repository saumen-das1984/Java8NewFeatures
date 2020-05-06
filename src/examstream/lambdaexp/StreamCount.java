package examstream.lambdaexp;

import java.util.ArrayList;
import java.util.List;

public class StreamCount {
	public static void main(String[] args) {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");

		long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();

		System.out.println(totalMatched);
	}
}
