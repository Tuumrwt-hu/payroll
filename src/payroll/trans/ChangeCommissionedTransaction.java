package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction implements Transaction {

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

}
