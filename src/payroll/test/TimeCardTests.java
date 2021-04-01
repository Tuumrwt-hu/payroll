package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.HourlyClassification;
import payroll.classification.TimeCard;
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
	
	@Test
	void testTwoTimeCardsToHourlyEmployee() {
		int empId = 3002;
		new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.5).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));

		String date1 = "2018-03-14";
		double hours1 = 5.5;
		new TimeCardTransaction(empId, date1, hours1).execute();

		String date2 = "2018-03-15";
		double hours2 = 10.0;
		new TimeCardTransaction(empId, date2, hours2).execute();

		Employee employee = PayrollDatabase.getEmployee(empId);
		PaymentClassification pc = employee.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;

		TimeCard timeCard1 = hc.getTimeCardOfDate(date1);
		assertNotNull(timeCard1);
		assertEquals(date1, timeCard1.getDate());
		assertEquals(hours1, timeCard1.getHours(), 0.001);

		TimeCard timeCard2 = hc.getTimeCardOfDate(date2);
		assertNotNull(timeCard2);
		assertEquals(date2, timeCard2.getDate());
		assertEquals(hours2, timeCard2.getHours());
	}

}
