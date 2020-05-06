package examstream.lambdaexp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsSorted {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0) };

		List<Employee> empList = Arrays.asList(arrayOfEmps);
		
		List<Employee> employeesList = empList.stream()
			      .sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()))
			      .collect(Collectors.toList());
		
		Stream<Employee> stream = employeesList.stream();
		stream.forEach(p -> System.out.println(p));

	}

}
