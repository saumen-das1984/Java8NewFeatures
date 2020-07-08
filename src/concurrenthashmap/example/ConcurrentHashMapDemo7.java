package concurrenthashmap.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo7 {

	public static void main(String[] args) {
		// create a ConcurrentHashMap and
		// add some values
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("Pencil", 1000);
		map.put("Laptop", 55000);
		map.put("Clothes", 4400);
		map.put("Mobile", 5300);

		try {

			// provide value for new key which is absent
			// using computeIfAbsent method
			map.computeIfAbsent(null, k -> 60000);
		} catch (Exception e) {

			// print new mapping
			System.out.println("Exception: " + e);
		}

	}

}
