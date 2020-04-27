package enhancement.collection.api;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.IntConsumer;

public class InterfaceSpliteratorForEachRemainingExample3 {

	public static void main(String[] args) {
		int[] i = { 1, 2, 3, 4 };
		Spliterator.OfInt spltr = Arrays.spliterator(i);
		System.out.println("Elements os Array-");
		spltr.forEachRemaining((IntConsumer) System.out::println);
	}

}
