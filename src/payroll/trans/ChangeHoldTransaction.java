package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeHoldTransaction extends ChangeEmployeeTransaction implements Transaction {

	public ChangeHoldTransaction(int empId) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doChange(Employee e) {
		// TODO Auto-generated method stub

	}

}
