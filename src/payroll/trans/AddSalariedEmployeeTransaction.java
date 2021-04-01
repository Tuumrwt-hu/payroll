package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.SalariedClassification;
import payroll.method.HoldMethod;

public class AddSalariedEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Override
	public void execute() {
		Employee e = new Employee(empId, name, address);
		e.setPaymentClassification(new SalariedClassification(salary));
		e.setPaymentMethod(new HoldMethod());
		PayrollDatabase.saveEmployee(e);
	}

}
