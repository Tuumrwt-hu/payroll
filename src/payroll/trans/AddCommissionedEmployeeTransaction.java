package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;

public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

}
