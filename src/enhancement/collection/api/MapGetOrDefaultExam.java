package enhancement.collection.api;

import java.util.HashMap;
import java.util.Map;

public class MapGetOrDefaultExam {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("C", "c");
		String val = map.getOrDefault("B", "Nah!");
		System.out.println(val);
	}

}
