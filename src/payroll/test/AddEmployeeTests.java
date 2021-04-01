package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.trans.AddHourlyEmployeeTransaction;

class AddEmployeeTests {

	// Test for
	// AddEmp empId name address H hourly-rate
	@Test
	void testAddHourlyEmployee() {
		// Assumptions
		int empId = 1001;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;
		// Actions
		Transaction t = new AddHourlyEmployeeTransaction(
				empId, name, address, hourlyRate);
		t.execute();
		// Assertions
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNotNull(e);
		assertEquals(empId, e.getEmpId());
		assertEquals(name, e.getName());
		assertEquals(address, e.getAddress());
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;
		assertEquals(hourlyRate, hc.getHourlyRate(), 0.01);
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);
	}

}
