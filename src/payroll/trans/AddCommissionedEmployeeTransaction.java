package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;

public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	public AddCommissionedEmployeeTransaction(int empId, String name, String address, double salary,
			double commissionRate) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

}
