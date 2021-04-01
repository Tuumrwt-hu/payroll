package payroll;

import java.util.LinkedHashMap;
import java.util.Map;

public class PayrollDatabase {
	
	private static Map<Integer, Employee> employees = new LinkedHashMap<>();

	public static Employee getEmployee(int empId) {
		return employees.get(empId);
	}

	public static void saveEmployee(Employee e) {
		employees.put(e.getEmpId(), e);
	}

	public static void deleteEmployee(int empId) {
		employees.remove(empId);
	}

}
