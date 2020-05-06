package enhancement.collection.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionExample {

	public static void main(String[] args) {
		Predicate<Integer> positive = i -> i > 0;
		Predicate<Integer> and = positive.and(i->i>10);
		Predicate<Integer> or = positive.or(i->i>10);
		Predicate<Integer> negate = positive.negate();
		List<Integer> integerList = Arrays.asList(new Integer(1), new Integer(10), new Integer(200), new Integer(101),
				new Integer(-10), new Integer(0));
		List<Integer> filteredList = filterList(integerList, positive);
		System.out.println("Case 1 : ---------------------");
		filteredList.forEach(System.out::println);
		List<Integer> filteredList1 = filterList(integerList, and);
		System.out.println("Case 2 : ---------------------");
		filteredList1.forEach(System.out::println);
		List<Integer> filteredList2 = filterList(integerList, or);
		System.out.println("Case 3 : ---------------------");
		filteredList2.forEach(System.out::println);
		List<Integer> filteredList3 = filterList(integerList, negate);
		System.out.println("Case 4 : ---------------------");
		filteredList3.forEach(System.out::println);
	}

	public static List<Integer> filterList(List<Integer> listOfIntegers, Predicate<Integer> predicate) {
		List<Integer> filteredList = new ArrayList<Integer>();
		for (Integer integer : listOfIntegers) {
			if (predicate.test(integer)) {
				filteredList.add(integer);
			}
		}
		return filteredList;
	}
}
