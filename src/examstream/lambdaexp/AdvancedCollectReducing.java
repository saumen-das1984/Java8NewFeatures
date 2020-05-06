package examstream.lambdaexp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class AdvancedCollectReducing {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0) };

		List<Employee> empList = Arrays.asList(arrayOfEmps);

		Double percentage = 10.0;
		Double salIncrOverhead = empList.stream()
				.collect(Collectors.reducing(0.0, e -> e.getEmpSal() * percentage / 100, (s1, s2) -> s1 + s2));
		
		System.out.println(salIncrOverhead);
		
		Comparator<Employee> byNameLength = Comparator.comparing(Employee::getEmpName);
	    
	    Map<Character, Optional<Employee>> longestNameByAlphabet = empList.stream().collect(
	      Collectors.groupingBy(e -> new Character(e.getEmpName().charAt(0)),
	        Collectors.reducing(BinaryOperator.maxBy(byNameLength))));
	    
	    System.out.println(longestNameByAlphabet.toString());
	}

}
