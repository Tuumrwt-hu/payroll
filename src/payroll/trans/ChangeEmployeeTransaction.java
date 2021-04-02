package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;

public abstract class ChangeEmployeeTransaction implements Transaction {

	protected int empId;

	public ChangeEmployeeTransaction() {
		super();
	}
	
	public ChangeEmployeeTransaction(int empId) {
		super();
		this.empId = empId;
	}

	@Override
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(empId);
		if (e != null) {
			doChange(e);
		}
	}

	protected abstract void doChange(Employee e);

}