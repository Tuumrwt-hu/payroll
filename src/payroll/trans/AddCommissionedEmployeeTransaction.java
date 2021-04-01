package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;

public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	private double salary;
	private double commissionRate;

	public AddCommissionedEmployeeTransaction(int empId, String name, String address, double salary,
			double commissionRate) {
		super(empId, name, address);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

}
