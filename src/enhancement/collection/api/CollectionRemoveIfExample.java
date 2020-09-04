package enhancement.collection.api;

import java.util.ArrayList;
import java.util.List;

import test.app.Employee;

public class CollectionRemoveIfExample {
	static List<Employee> employeeList = new ArrayList<>();
	public static void main(String[] args) {
		employeeList.add(new Employee("Tom Jones", 45, 7000.00));
	    employeeList.add(new Employee("Harry Major", 25, 10000.00));
	    employeeList.add(new Employee("Ethan Hardy", 65, 8000.00));
	    employeeList.add(new Employee("Nancy Smith", 22, 12000.00));
	    employeeList.add(new Employee("Deborah Sprightly", 29, 9000.00));

	    employeeList.removeIf((Employee emp) -> emp.getAge()>= 30);
	    
	    /* Removal from an ArrayList using an iterator has time complexity of O(n2), 
	     * while the same operation when performed using Java 8’s new Collection.removeIf() method has a complexity of O(n). 
	     * This is a significant improvement in performance. */

	    System.out.println("Employees below the age of 30");
	    employeeList.forEach(System.out::println);

	}

}
