package payroll;

import payroll.classification.HourlyClassification;
import payroll.method.HoldMethod;

public class Employee {

	private int empId;
	private String name;
	private String address;

	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public Object getEmpId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

	public PaymentMethod getPaymentMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPaymentClassification(HourlyClassification hourlyClassification) {
		// TODO Auto-generated method stub
		
	}

	public void setPaymentMethod(HoldMethod holdMethod) {
		// TODO Auto-generated method stub
		
	}

}
