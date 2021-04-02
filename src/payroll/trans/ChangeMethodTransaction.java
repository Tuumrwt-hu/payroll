package payroll.trans;

import payroll.Employee;
import payroll.PaymentMethod;
import payroll.Transaction;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

	public ChangeMethodTransaction() {
		super();
	}

	public ChangeMethodTransaction(int empId) {
		super(empId);
	}

	protected abstract PaymentMethod getMethod();

	@Override
	protected void doChange(Employee e) {
		e.setPaymentMethod(getMethod());
	}

}