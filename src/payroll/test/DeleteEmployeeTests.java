package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.exception.NoSuchEmployeeException;
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
	
	@Test
	void deleteEmployeeNotExists() {
		int empId = 200200;
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNull(e);

		assertThrows(NoSuchEmployeeException.class, () -> {
			new DeleteEmployeeTransaction(empId).execute();
		});
	}

}
