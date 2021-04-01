package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.CommissionedClassification;
import payroll.classification.SalesReceipt;
import payroll.exception.NoSuchEmployeeException;
import payroll.exception.NotCommissionedClassificationException;
import payroll.trans.AddCommissionedEmployeeTransaction;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.AddSalariedEmployeeTransaction;
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
	
	@Test
	void testTwoSalesReceiptToCommissionedEmployee() {
		int empId = 4002;
		new AddCommissionedEmployeeTransaction(empId, "Bill", "Home", 3456.0, 0.02).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		String date1 = "2018-03-14";
		double amount1 = 1000;
		new SalesReceiptTransaction(empId, date1, amount1).execute();
		String date2 = "2018-03-15";
		double amount2 = 2000;
		new SalesReceiptTransaction(empId, date2, amount2).execute();
		
		Employee e = PayrollDatabase.getEmployee(empId);
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof CommissionedClassification);
		
		CommissionedClassification cc = (CommissionedClassification) pc;
		SalesReceipt salesReceipt1 = cc.getSalesReceiptOfDate(date1);
		assertEquals(date1, salesReceipt1.getDate());
		assertEquals(amount1, salesReceipt1.getAmount(), 0.001);
		SalesReceipt salesReceipt2 = cc.getSalesReceiptOfDate(date2);
		assertEquals(date2, salesReceipt2.getDate());
		assertEquals(amount2, salesReceipt2.getAmount(), 0.001);
	}
	
	@Test
	void testOneSalesReceiptToHourlyEmployee() {
		int empId = 4003;
		new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.5).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		assertThrows(NotCommissionedClassificationException.class, ()->{
			new SalesReceiptTransaction(empId, "2018-03-14", 1000).execute();
		});
	}
	
	@Test
	void testOneSalesReceiptToSalariedEmployee() {
		int empId = 4004;
		new AddSalariedEmployeeTransaction(empId, "Bill", "Home", 4000.0).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		assertThrows(NotCommissionedClassificationException.class, ()->{
			new SalesReceiptTransaction(empId, "2018-03-14", 1000).execute();
		});
	}
	
	@Test
	void testSalesReceiptNoSuchEmployee() {
		int empId = 400555;
		assertNull(PayrollDatabase.getEmployee(empId));
		
		assertThrows(NoSuchEmployeeException.class, ()->{
			new SalesReceiptTransaction(empId, "2018-03-14", 1000).execute();
		});
	}

}
