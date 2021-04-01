package payroll.trans;

import payroll.Transaction;

public class TimeCardTransaction implements Transaction {

	private int empId;
	private String date;
	private double hours;

	public TimeCardTransaction(int empId, String date, double hours) {
		this.empId = empId;
		this.date = date;
		this.hours = hours;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
