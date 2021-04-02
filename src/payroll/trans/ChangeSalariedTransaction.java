package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classification.SalariedClassification;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction implements Transaction {

	private double salary;

	public ChangeSalariedTransaction(int empId, double salary) {
		super(empId);
		this.salary = salary;
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		return new SalariedClassification(salary);
	}

}
