package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;

public class ChangeNameTransaction implements Transaction {

	private int empId;
	private String newName;

	public ChangeNameTransaction(int empId, String newName) {
		this.empId = empId;
		this.newName = newName;
	}

	@Override
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(empId);
		if (e != null) {
			e.setName(newName);
		}
	}

}
