package examstream.lambdaexp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsMap {
	
	

	public static void main(String[] args) {
		Integer[] empIds = { 1, 2, 3 };
		
		Employee employeeRepository = new Employee();

		List<Employee> employeesList = Stream.of(empIds).map(employeeRepository::findById).filter(e -> e != null).collect(Collectors.toList());
		
		Stream<Employee> stream = employeesList.stream();
		stream.forEach(p -> System.out.println(p));
	}
}
