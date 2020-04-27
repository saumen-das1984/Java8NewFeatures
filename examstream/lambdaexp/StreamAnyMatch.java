package examstream.lambdaexp;

import java.util.ArrayList;
import java.util.List;

public class StreamAnyMatch {
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

		boolean matched = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
		System.out.println(matched);
	}
}
