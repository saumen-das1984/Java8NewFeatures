package enhancement.collection.api;

import java.util.HashMap;
import java.util.Map;

public class MapReplaceAll {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
	    map.put("C", "c");
	    map.put("B", "b");
	    map.replaceAll((k, v) -> "x");
	    map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
	    map.replace("B", "x", "m");
	    map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
	}

}
