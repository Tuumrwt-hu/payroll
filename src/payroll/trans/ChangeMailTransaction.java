package payroll.trans;

import payroll.PaymentMethod;
import payroll.Transaction;

public class ChangeMailTransaction extends ChangeMethodTransaction implements Transaction {

	private String mailAddress;

	public ChangeMailTransaction(int empId, String mailAddress) {
		super(empId);
		this.mailAddress = mailAddress;
	}

	@Override
	protected PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
