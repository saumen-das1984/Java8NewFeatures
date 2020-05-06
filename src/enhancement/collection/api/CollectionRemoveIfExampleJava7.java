package enhancement.collection.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import test.app.Employee;

public class CollectionRemoveIfExampleJava7 {
	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) {
		employeeList.add(new Employee("Tom Jones", 45, 7000.00));
		employeeList.add(new Employee("Harry Major", 25, 10000.00));
		employeeList.add(new Employee("Ethan Hardy", 65, 8000.00));
		employeeList.add(new Employee("Nancy Smith", 22, 12000.00));
		employeeList.add(new Employee("Deborah Sprightly", 29, 9000.00));

		for (Iterator empIterator = employeeList.iterator(); empIterator.hasNext();) {
			Employee emp = (Employee) empIterator.next();
			if (emp.getAge() > 30) {
				empIterator.remove();
			}
		}
		
		/*We used a for-loop with an iterator to iterate over the ArrayList. A single loop implies a time complexity of O(n).
		Further, as an ArrayList stores elements in sequential storage in memory, the removal of an element from the middle 
		implies that all the elements to the right of(or after) the removed element have to be moved 1 place each towards the left.
		This needs to be done in order to fill up the empty space left by the removed element. The movement of elements for 
		these place would further require time proportional to O(m).Since we potentially will need to move the elements for 
		every removal, the total complexity across all the removals equals O(n) X O(m) ~ O(n2).*/

		System.out.println("Employees below the age of 30");
		employeeList.forEach(System.out::println);
	}

}
