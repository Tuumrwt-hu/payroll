package payroll;

import payroll.classification.HourlyClassification;
import payroll.method.HoldMethod;

public class Employee {

	private int empId;
	private String name;
	private String address;
	private PaymentClassification paymentClassification;
	private PaymentMethod paymentMethod;

	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public PaymentClassification getPaymentClassification() {
		return paymentClassification;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentClassification(HourlyClassification hourlyClassification) {
		// TODO Auto-generated method stub
		
	}

	public void setPaymentMethod(HoldMethod holdMethod) {
		// TODO Auto-generated method stub
		
	}

}
