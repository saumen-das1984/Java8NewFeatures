package examstream.lambdaexp;

import java.util.Arrays;
import java.util.List;

public class ReductionOperationsReduce {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0) };

		List<Employee> empList = Arrays.asList(arrayOfEmps);

		Double sumSal = empList.stream().map(Employee::getEmpSal).reduce(0.0, Double::sum);
		System.out.println("Sum of salary : " + sumSal);
	}

}
