package examstream.lambdaexp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedCollectMapping {

	public static void main(String[] args) {
		Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
				new Employee(3, "Mark Zuckerberg", 300000.0) };

		List<Employee> empList = Arrays.asList(arrayOfEmps);

		Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
			      Collectors.groupingBy(e -> new Character(e.getEmpName().charAt(0)),
			        Collectors.mapping(Employee::getEmpId, Collectors.toList())));

		System.out.println(idGroupedByAlphabet.toString());
	}

}
