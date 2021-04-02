package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeSalariedTransaction extends ChangeEmployeeTransaction implements Transaction {

	public ChangeSalariedTransaction(int empId, double salary) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doChange(Employee e) {
		// TODO Auto-generated method stub

	}

}
