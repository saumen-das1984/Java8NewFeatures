package enhancement.collection.api;

import java.util.HashMap;
import java.util.Map;

public class MapMerge {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
	    map.put("C", "c");
	    map.put("B", "b");
	    map.merge("B", "NEW", (v1, v2) -> v1 + v2);
	    System.out.println(map.get("B"));
	}
}
