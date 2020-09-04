package exampredicate.lambdaexp;

import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		Predicate<String> i = (s) -> s.length() > 5;

		System.out.println(i.test("google.com "));
	}
}
