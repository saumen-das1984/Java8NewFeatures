package enhancement.collection.api;

import java.util.HashMap;
import java.util.Map;

public class MapPutIfAbsent {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
	    map.put("C", "c");
//	    map.put("B", "b");
	    map.putIfAbsent("B", "x");
	    System.out.println(map.get("B"));
	}
}
