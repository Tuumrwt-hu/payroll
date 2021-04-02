package payroll.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import payroll.Paycheck;
import payroll.trans.AddSalariedEmployeeTransaction;
import payroll.trans.PaydayTransaction;

// Test for Payday

class PaydayTests {

	@Test
	void testPaydaySalariedHold() {
		int empId = 6001;
		String name = "Bill";
		double salary = 3000.0;
		new AddSalariedEmployeeTransaction(empId, name, "Home", salary).execute();
		PaydayTransaction t = new PaydayTransaction();
		t.execute();

		Paycheck p = t.getPaycheckOf(empId);
		assertEquals(empId, p.getEmpId());
		assertEquals(name, p.getName());
		assertEquals(salary, p.getAmount(), 0.001);
		assertEquals("HOLD", p.getDisposition());
	}

}
