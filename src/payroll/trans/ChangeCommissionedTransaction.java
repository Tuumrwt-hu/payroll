package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction implements Transaction {

	public ChangeCommissionedTransaction(int empId, double salary, double commissionRate) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

}
