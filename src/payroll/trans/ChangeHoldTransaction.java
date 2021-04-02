package payroll.trans;

import payroll.Employee;
import payroll.PaymentMethod;
import payroll.Transaction;
import payroll.method.HoldMethod;

public class ChangeHoldTransaction extends ChangeEmployeeTransaction implements Transaction {

	public ChangeHoldTransaction(int empId) {
		super(empId);
	}

	@Override
	protected void doChange(Employee e) {
		e.setPaymentMethod(getMethod());
	}

	protected PaymentMethod getMethod() {
		return new HoldMethod();
	}

}
