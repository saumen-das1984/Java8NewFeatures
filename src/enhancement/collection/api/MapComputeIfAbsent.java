package enhancement.collection.api;

import java.util.HashMap;

public class MapComputeIfAbsent {

	public static void main(String[] args) {

		// create a HashMap and add some values
		HashMap<Integer, String> map = new HashMap<>();
		map.put(10, "Aman");
		map.put(20, "Suraj");
		map.put(30, "Harsh");

		// print map details
		System.out.println("HashMap:\n" + map.toString());

		// provide value for new key which is absent
		// using computeIfAbsent method
		map.computeIfAbsent(40, k -> "Sanjeet");

		// this will not effect anything
		// because key 1 is present
		map.computeIfAbsent(10, k -> "Amarjit");

		// print new mapping
		System.out.println("New HashMap:\n" + map.toString());

	}

}
