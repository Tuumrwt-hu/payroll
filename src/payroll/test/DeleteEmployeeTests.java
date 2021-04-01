package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.DeleteEmployeeTransaction;

class DeleteEmployeeTests {

	@Test
	void testDeleteEmployeeExists() {
		int empId = 2001;
		new AddHourlyEmployeeTransaction(empId, "Bill", "Home", 12.5).execute();

		Transaction t = new DeleteEmployeeTransaction(empId);
		t.execute();

		Employee e = PayrollDatabase.getEmployee(empId);
		assertNull(e);
	}

}
