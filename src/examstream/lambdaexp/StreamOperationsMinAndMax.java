package examstream.lambdaexp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamOperationsMinAndMax {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0) };

		List<Employee> empList = Arrays.asList(arrayOfEmps);
		
		Employee firstEmp = empList.stream()
			      .min((e1, e2) -> e1.getEmpId() - e2.getEmpId())
			      .orElseThrow(NoSuchElementException::new);
		
		System.out.println("First Employee : "+firstEmp);
		
		Employee maxSalEmp = empList.stream()
			      .max(Comparator.comparing(Employee::getEmpSal))
			      .orElseThrow(NoSuchElementException::new);
		
		System.out.println("Max Salary Employee : "+maxSalEmp);

	}

}
