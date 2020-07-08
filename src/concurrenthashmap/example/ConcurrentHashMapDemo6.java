package concurrenthashmap.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo6 {

	public static void main(String[] args) {
		// create a ConcurrentHashMap and
		// add some values
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "1000RS");
		map.put(2, "5009RS");
		map.put(3, "1300RS");

		// print map details
		System.out.println("ConcurrentHashMap : \n" + map.toString());

		// provide value for new key which is absent
		// using computeIfAbsent method
		map.computeIfAbsent(4, k -> "6000RS");

		// this will not effect anything
		// because key 1 is present
		map.computeIfAbsent(1, k -> "8000RS");

		// print new mapping
		System.out.println("new ConcurrentHashMap :\n" + map);

	}

}
