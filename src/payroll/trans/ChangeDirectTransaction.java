package payroll.trans;

import payroll.PaymentMethod;
import payroll.Transaction;
import payroll.method.DirectMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction implements Transaction {

	private String bank;
	private String account;

	public ChangeDirectTransaction(int empId, String bank, String account) {
		super(empId);
		this.bank = bank;
		this.account = account;
	}

	protected PaymentMethod getMethod() {
		return new DirectMethod(bank, account);
	}

}
