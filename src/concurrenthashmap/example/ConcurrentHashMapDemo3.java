package concurrenthashmap.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo3 {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<Integer, String>();

		chm.put(100, "Geeks");
		chm.put(101, "for");
		chm.put(102, "Geeks");
		chm.put(103, "Gfg");
		chm.put(104, "GFG");

		// Displaying the HashMap
		System.out.println("Initial Mappings are: " + chm);

		// Inserting non-existing key along with value
		String returned_value = (String) chm.putIfAbsent(108, "All");

		// Verifying the returned value
		System.out.println("Returned value is: " + returned_value);

		// Displayin the new map
		System.out.println("New mappings are: " + chm);

	}

}
