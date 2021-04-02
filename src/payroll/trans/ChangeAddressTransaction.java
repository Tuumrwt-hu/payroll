package payroll.trans;

import payroll.Employee;
import payroll.Transaction;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction implements Transaction {

	private String newAddress;

	public ChangeAddressTransaction(int empId, String newAddress) {
		this.empId = empId;
		this.newAddress = newAddress;
	}

	protected void doChange(Employee e) {
		e.setAddress(newAddress);
	}

}
