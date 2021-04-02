package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeHourlyTransaction extends ChangeEmployeeTransaction implements Transaction {

	public ChangeHourlyTransaction(int empId, double hourlyRate) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doChange(Employee e) {
		// TODO Auto-generated method stub

	}

}
