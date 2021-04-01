package payroll.trans;

import payroll.Transaction;

public class SalesReceiptTransaction implements Transaction {

	private int empId;
	private String date;
	private double amount;

	public SalesReceiptTransaction(int empId, String date, double amount) {
		this.empId = empId;
		this.date = date;
		this.amount = amount;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
