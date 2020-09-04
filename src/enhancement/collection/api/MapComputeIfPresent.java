package enhancement.collection.api;

import java.util.HashMap;
import java.util.Map;

public class MapComputeIfPresent {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("C", "c");
		map.put("B", "b");
		map.computeIfPresent("B", (k, v) -> v.concat(" - new "));
		System.out.println(map.get("B"));
	}

}
