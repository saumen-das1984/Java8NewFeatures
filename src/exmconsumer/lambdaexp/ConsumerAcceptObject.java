package exmconsumer.lambdaexp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAcceptObject {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("John", 3), new Student("Mark", 4));

		acceptAllEmployee(students, e -> System.out.println(e.name));
		acceptAllEmployee(students, e -> {
			e.gpa *= 1.5;
		});
		acceptAllEmployee(students, e -> System.out.println(e.name + " : " + e.gpa));
	}

	public static void acceptAllEmployee(List<Student> student, Consumer<Student> printer) {
		for (Student e : student) {
			printer.accept(e);
		}
	}
}
