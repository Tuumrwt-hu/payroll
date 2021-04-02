package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeDirectTransaction extends ChangeEmployeeTransaction implements Transaction {

	public ChangeDirectTransaction(int empId, String bank, String account) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doChange(Employee e) {
		// TODO Auto-generated method stub

	}

}
