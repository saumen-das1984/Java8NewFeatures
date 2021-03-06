package examstream.lambdaexp;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamsExample {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0) };

		List<Employee> empList = Arrays.asList(arrayOfEmps);

		empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));

		System.out.println(empList);

	}

}
