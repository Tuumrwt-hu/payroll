package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;

public class ChangeAddressTransaction implements Transaction {

	private int empId;
	private String newAddress;

	public ChangeAddressTransaction(int empId, String newAddress) {
		this.empId = empId;
		this.newAddress = newAddress;
	}

	@Override
	public void execute() {
		Employee e = PayrollDatabase.getEmployee(empId);
		if (e != null) {
			e.setAddress(newAddress);
		}
	}

}
