package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;

public abstract class ChangeEmployeeTransaction {

	protected int empId;

	protected abstract void doChange(Employee e);

	public ChangeEmployeeTransaction() {
		super();
	}

	@Override
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(empId);
		if (e != null) {
			doChange(e);
		}
	}

}