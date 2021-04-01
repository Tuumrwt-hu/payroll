package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.HourlyClassification;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.TimeCardTransaction;

class TimeCardTests {

	@Test
	void testOneTimeCardToHourlyEmployee() {
		int empId = 3001;
		new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.5).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));

		String date = "2018-03-14";
		double hours = 7.5;
		Transaction t = new TimeCardTransaction(empId, date, hours);
		t.execute();

		Employee e = PayrollDatabase.getEmployee(empId);
		assertNotNull(e);
		assertEquals(empId, e.getEmpId());
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;
		TimeCard tc = hc.getTimeCardOfDate(date);
		assertNotNull(tc);
		assertEquals(date, tc.getDate());
		assertEquals(hours, tc.getHours(), 0.001);
	}

}
