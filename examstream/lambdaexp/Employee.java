package examstream.lambdaexp;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	
	public int empId;
	public String empName;
	public double empSal;
	
	public Employee() {};
	
	public Employee(int empId, String empName, double empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	
//	public static void setEmpRepos(List<Employee> employeeRepository) {
//		employeeRepository = employeeRepository;
//	}
	
	
	public void salaryIncrement(double incrementFactor)
	{
		empSal = empSal * incrementFactor;
	}
	
	public Employee findById(int empId)
	{
		System.out.println("Emp ID : "+empId);
		
		Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
		empMap.put(1, new Employee(1, "Jeff Bezos", 100000.0));
		empMap.put(2, new Employee(2, "Bill Gates", 200000.0));
		empMap.put(3, new Employee(3, "Mark Zuckerberg", 300000.0));
		
		if (empMap.containsKey(empId)) {
			Employee employee = empMap.get(empId);
			if (employee.getEmpId()==empId)
			{
				return employee;
			}
			else
			{
				return null;
			}
		}
		return null;	
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

}
