package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeDirectTransaction extends ChangeEmployeeTransaction implements Transaction {

	private String bank;
	private String account;

	public ChangeDirectTransaction(int empId, String bank, String account) {
		super(empId);
		this.bank = bank;
		this.account = account;
	}

	@Override
	protected void doChange(Employee e) {
		e.setPaymentMethod(new DirectMethod(bank, account));
	}

}
