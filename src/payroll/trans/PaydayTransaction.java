package payroll.trans;

import java.util.LinkedHashMap;
import java.util.Map;

import payroll.Employee;
import payroll.Paycheck;
import payroll.PayrollDatabase;
import payroll.Transaction;

public class PaydayTransaction implements Transaction {

	private Map<Integer, Paycheck> paychecks = new LinkedHashMap<>();
	
	@Override
	public void execute() {
		// Clear paychecks
		paychecks.clear();
		
		// Pay for each employee and keep the paycheck
		for (Employee e : PayrollDatabase.listAllEmployees()) {
			// Create a blank paycheck
			Paycheck paycheck = new Paycheck();
			// Fill in the paycheck
			e.pay(paycheck);
			// Keep the paycheck
			paychecks.put(e.getEmpId(), paycheck);
		}
	}

	public Paycheck getPaycheckOf(int empId) {
		return paychecks.get(empId);
	}

}
