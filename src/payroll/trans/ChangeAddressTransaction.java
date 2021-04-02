package payroll.trans;

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
		// TODO Auto-generated method stub

	}

}
