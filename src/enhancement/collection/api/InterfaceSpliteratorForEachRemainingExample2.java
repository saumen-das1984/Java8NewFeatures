package enhancement.collection.api;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class InterfaceSpliteratorForEachRemainingExample2 {

	public static void main(String[] args) {
		// Create an array list
		ArrayList<Integer> list = new ArrayList<>();
		// Add values to the list.
		list.add(100);
		list.add(-200);
		list.add(300);
		list.add(-400);
		list.add(500);
		// Obtain a Stream to the array list.
		Stream<Integer> str = list.stream();
		Spliterator<Integer> splitr1 = str.spliterator();
		System.out.println("Elements Exist in arraylist :");
		// forEachRemaining method
		splitr1.forEachRemaining((n) -> System.out.println(n));
	}
}
