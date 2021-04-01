package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.CommissionedClassification;
import payroll.classification.SalesReceipt;
import payroll.trans.AddCommissionedEmployeeTransaction;
import payroll.trans.SalesReceiptTransaction;

class SalesReceiptTests {

	@Test
	void testOneSalesReceiptToCommissionedEmployee() {
		int empId = 4001;
		new AddCommissionedEmployeeTransaction(empId, "Bill", "Home", 3456.0, 0.02).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		String date = "2018-03-14";
		double amount = 1000;
		Transaction t = new SalesReceiptTransaction(empId, date, amount);
		t.execute();
		
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertNotNull(employee);
		PaymentClassification pc = employee.getPaymentClassification();
		assertTrue(pc instanceof CommissionedClassification);
		CommissionedClassification cc = (CommissionedClassification) pc;
		SalesReceipt sr = cc.getSalesReceiptOfDate(date);
		assertEquals(date, sr.getDate());
		assertEquals(amount, sr.getAmount(), 0.001);
	}

}
