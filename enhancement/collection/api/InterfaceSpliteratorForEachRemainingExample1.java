package enhancement.collection.api;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class InterfaceSpliteratorForEachRemainingExample1 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Skype", "Facebook", "Instagram", "Twitter");
		// Getting Spliterator object
		Spliterator<String> namesSpliterator = names.spliterator();
		// Use tryAdvance() to display(action) elements of list.
		System.out.println("Next Element Present? " + namesSpliterator.tryAdvance(System.out::println));
		System.out.println("Remaining Name Present in the List:");
		namesSpliterator.forEachRemaining(System.out::println);
	}

}
