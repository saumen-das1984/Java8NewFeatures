package concurrenthashmap.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo5 {

	public static void main(String[] args) {
		// create a ConcurrentHashMap and
		// add some values
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		map.put("Pencil", 1000);
		map.put("Laptop", 55000);
		map.put("Clothes", 4400);
		map.put("Mobile", 5300);

		// print map details
		System.out.println("ConcurrentHashMap :\n " + map.toString());

		// provide value for new key which is absent
		// using computeIfAbsent method
		map.computeIfAbsent("PC", k -> 60000);
		map.computeIfAbsent("Charger", k -> 800);

		// print new mapping
		System.out.println("new ConcurrentHashMap :\n " + map);

	}

}
