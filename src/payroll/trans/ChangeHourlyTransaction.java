package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classification.HourlyClassification;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction implements Transaction {

	private double hourlyRate;

	public ChangeHourlyTransaction(int empId, double hourlyRate) {
		super(empId);
		this.hourlyRate = hourlyRate;
	}

	protected PaymentClassification getPaymentClassification() {
		return new HourlyClassification(hourlyRate);
	}

}
