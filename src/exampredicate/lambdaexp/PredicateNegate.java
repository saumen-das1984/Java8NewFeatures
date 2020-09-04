package exampredicate.lambdaexp;

import java.util.function.Predicate;

public class PredicateNegate {
	public static void main(String[] args) {
		Predicate<String> i = (s) -> s.length() > 5;

		System.out.println(i.negate().test("google.com "));
	}
}
