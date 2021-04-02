package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.Transaction;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

	public ChangeClassificationTransaction() {
		super();
	}

	public ChangeClassificationTransaction(int empId) {
		super(empId);
	}

	protected abstract PaymentClassification getPaymentClassification();

	@Override
	protected void doChange(Employee e) {
		e.setPaymentClassification(getPaymentClassification());
	}

}