package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classification.SalariedClassification;

public class ChangeSalariedTransaction extends ChangeEmployeeTransaction implements Transaction {

	private double salary;

	public ChangeSalariedTransaction(int empId, double salary) {
		super(empId);
		this.salary = salary;
	}

	@Override
	protected void doChange(Employee e) {
		e.setPaymentClassification(getPaymentClassification());
	}

	protected PaymentClassification getPaymentClassification() {
		return new SalariedClassification(salary);
	}

}
