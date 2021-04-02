package payroll.trans;

import payroll.PaymentMethod;
import payroll.Transaction;
import payroll.method.HoldMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction implements Transaction {

	public ChangeHoldTransaction(int empId) {
		super(empId);
	}

	@Override
	protected PaymentMethod getMethod() {
		return new HoldMethod();
	}

}
