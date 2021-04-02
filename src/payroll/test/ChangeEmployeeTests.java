package payroll.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PaymentMethod;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.CommissionedClassification;
import payroll.classification.HourlyClassification;
import payroll.classification.SalariedClassification;
import payroll.method.HoldMethod;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.AddSalariedEmployeeTransaction;
import payroll.trans.ChangeAddressTransaction;
import payroll.trans.ChangeCommissionedTransaction;
import payroll.trans.ChangeDirectTransaction;
import payroll.trans.ChangeHoldTransaction;
import payroll.trans.ChangeHourlyTransaction;
import payroll.trans.ChangeNameTransaction;
import payroll.trans.ChangeSalariedTransaction;

//Test for
//用例5  更改雇员明细。
//执行ChgEmp操作时，系统会更改对应雇员记录的详细信息之一。该操的几种操作形式如下：
//ChgEmp EmpId name “name”	更改雇员名
//ChgEmp EmpId address “address”	更改雇员地址
//ChgEmp EmpId hourly hourly-rate	更改每小时报酬
//ChgEmp EmpId salaried salary	更改薪水
//ChgEmp EmpId commissioned salary rate	更改酬金
//ChgEmp EmpId hold	持有支票
//ChgEmp EmpId direct “bank” “account”	直接存款
//ChgEmp EmpId mail “address”	邮寄支票
//异常情况：操作错误。
//如果描述操作的结构不正确，或者EmpId没有引用到真正的雇员，那么打印一条错误信息，
//不进行进一步的处理。

class ChangeEmployeeTests {

	// Test for
	// ChgEmp EmpId name “name”	更改雇员名
	@Test
	void testChangeName() {
		int empId = 5001;
		String name = "Bill";
		String address = "Home";
		double salary = 3000.0;
		
		new AddSalariedEmployeeTransaction(empId, name, address, salary).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		String newName = "Bob";
		Transaction t = new ChangeNameTransaction(empId, newName);
		t.execute();
		
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertEquals(newName, employee.getName());
	}
	
	// Test for
	// ChgEmp EmpId address “address”	更改雇员地址
	@Test
	void testChangeAddress() {
		int empId = 5002;
		String name = "Bill";
		String address = "Home";
		double salary = 3000.0;
		
		new AddSalariedEmployeeTransaction(empId, name, address, salary).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		String newAddress = "Bill's new home";
		Transaction t = new ChangeAddressTransaction(empId, newAddress);
		t.execute();
		
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertEquals(newAddress, employee.getAddress());
	}
	
	// Test for
	// ChgEmp EmpId hourly hourly-rate	更改每小时报酬
	@Test
	void testChangeHourlyRate() {
		int empId = 5003;
		String name = "Bill";
		String address = "Home";
		double salary = 3000.0;
		
		new AddSalariedEmployeeTransaction(empId, name, address, salary).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		double hourlyRate = 12.5;
		Transaction t = new ChangeHourlyTransaction(empId, hourlyRate);
		t.execute();
		
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertNotNull(employee);
		PaymentClassification pc = employee.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);
		HourlyClassification hc = (HourlyClassification) pc;
		assertEquals(hourlyRate, hc.getHourlyRate(), 0.001);
	}
	
	// Test for
	// ChgEmp EmpId salaried salary	更改薪水
	@Test
	void testChangeSalaried() {
		int empId = 5004;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;
		
		new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		double salary = 3000.0;
		Transaction t = new ChangeSalariedTransaction(empId, salary);
		t.execute();
		
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertNotNull(employee);
		PaymentClassification pc = employee.getPaymentClassification();
		assertTrue(pc instanceof SalariedClassification);
		SalariedClassification sc = (SalariedClassification) pc;
		assertEquals(salary, sc.getSalary(), 0.001);
	}
	
	// Test for
	// ChgEmp EmpId commissioned salary commission-rate	更改酬金
	@Test
	void testChangeCommissioned() {
		int empId = 5005;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;
		
		new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		double salary = 3000.0;
		double commissionRate = 0.02;
		Transaction t = new ChangeCommissionedTransaction(empId, salary, commissionRate);
		t.execute();
		
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertNotNull(employee);
		PaymentClassification pc = employee.getPaymentClassification();
		assertTrue(pc instanceof CommissionedClassification);
		CommissionedClassification cc = (CommissionedClassification) pc;
		assertEquals(salary, cc.getSalary(), 0.001);
		assertEquals(commissionRate, cc.getCommissionRate(), 0.001);
	}
	
	// Test for
	// ChgEmp EmpId hold	持有支票
	@Test
	void testChangeHoldMethod() {
		int empId = 5006;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;
		
		new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		Transaction t = new ChangeHoldTransaction(empId);
		t.execute();
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertNotNull(employee);
		PaymentMethod pm = employee.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);
	}
	
	// Test for
	// ChgEmp EmpId direct “bank” “account”	直接存款
	@Test
	void testChangeDirectMethod() {
		int empId = 5007;
		String name = "Bill";
		String address = "Home";
		double hourlyRate = 12.5;
		
		new AddHourlyEmployeeTransaction(empId, name, address, hourlyRate).execute();
		assertNotNull(PayrollDatabase.getEmployee(empId));
		
		String bank = "ICBC";
		String account = "123456789";
		Transaction t = new ChangeDirectTransaction(empId, bank, account);
		t.execute();
		Employee employee = PayrollDatabase.getEmployee(empId);
		assertNotNull(employee);
		PaymentMethod pm = employee.getPaymentMethod();
		assertTrue(pm instanceof DirectMethod);
		DirectMethod mm = (DirectMethod) pm;
		assertEquals(bank, mm.getBank());
		assertEquals(account, mm.getAccount());
	}

}
