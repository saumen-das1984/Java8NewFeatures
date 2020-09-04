package examstream.lambdaexp;

import java.util.stream.Stream;

public class StreamOperationsFindFirst {

	public static void main(String[] args) {
		Integer[] empIds = { 1, 2, 3, 4 };
		
		Employee employeeRepository = new Employee();

		Employee employee = Stream.of(empIds).map(employeeRepository::findById).filter(e -> e != null)
				.filter(e -> e.getEmpSal() > 100000).findFirst().orElse(null);

		System.out.println("employee "+employee);
	}

}
