package enhancement.collection.api;

import java.util.HashMap;
import java.util.Map;

public class MapForEachExam {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("C", "c");
		map.put("B", "b");
		map.put("Z", "z");
		map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));

	}

}
