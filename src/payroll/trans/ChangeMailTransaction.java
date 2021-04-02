package payroll.trans;

import payroll.PaymentMethod;
import payroll.Transaction;

public class ChangeMailTransaction extends ChangeMethodTransaction implements Transaction {

	public ChangeMailTransaction(int empId, String mailAddress) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
