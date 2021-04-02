package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction implements Transaction {

	private double salary;
	private double commissionRate;

	public ChangeCommissionedTransaction(int empId, double salary, double commissionRate) {
		super(empId);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

}
