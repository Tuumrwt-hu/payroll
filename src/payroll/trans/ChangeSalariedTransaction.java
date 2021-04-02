package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeSalariedTransaction extends ChangeEmployeeTransaction implements Transaction {

	private double salary;

	public ChangeSalariedTransaction(int empId, double salary) {
		super(empId);
		this.salary = salary;
	}

	@Override
	protected void doChange(Employee e) {
		// TODO Auto-generated method stub

	}

}
