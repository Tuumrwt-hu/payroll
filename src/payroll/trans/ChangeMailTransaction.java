package payroll.trans;

import payroll.PaymentMethod;
import payroll.Transaction;

public class ChangeMailTransaction extends ChangeMethodTransaction implements Transaction {

	@Override
	protected PaymentMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
