package payroll.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.trans.AddSalariedEmployeeTransaction;
import payroll.trans.ChangeNameTransaction;

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

}
