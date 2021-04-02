package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeNameTransaction extends ChangeEmployeeTransaction implements Transaction {

	private String newName;

	public ChangeNameTransaction(int empId, String newName) {
		this.empId = empId;
		this.newName = newName;
	}

	@Override
	protected void doChange(Employee e) {
		e.setName(newName);
	}

}
