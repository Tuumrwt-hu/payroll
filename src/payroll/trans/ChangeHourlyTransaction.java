package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeHourlyTransaction extends ChangeEmployeeTransaction implements Transaction {

	private double hourlyRate;

	public ChangeHourlyTransaction(int empId, double hourlyRate) {
		super(empId);
		this.hourlyRate = hourlyRate;
	}

	@Override
	protected void doChange(Employee e) {
		// TODO Auto-generated method stub

	}

}
