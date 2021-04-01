package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.method.HoldMethod;

public abstract class AddEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;

	public AddEmployeeTransaction() {
		super();
	}

	public AddEmployeeTransaction(int empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	protected abstract PaymentClassification getPaymentClassification();

	@Override
	public void execute() {
		Employee e = new Employee(empId, name, address);
		e.setPaymentClassification(getPaymentClassification());
		e.setPaymentMethod(new HoldMethod());
		PayrollDatabase.saveEmployee(e);
	}

}