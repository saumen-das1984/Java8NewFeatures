package exampredicate.lambdaexp;

import java.util.function.Predicate;

public class PredicateisEqual {
	public static void main(String[] args) {
		Predicate<String> i = Predicate.isEqual("asdf");

		System.out.println(i.test("google.com "));
	}
}
