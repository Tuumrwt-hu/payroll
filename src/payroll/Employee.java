package payroll;

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

	public void setPaymentClassification(PaymentClassification paymentClassification) {
		this.paymentClassification = paymentClassification;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void pay(Paycheck paycheck) {
		// Fill in empId and name
		paycheck.setEmpId(empId);
		paycheck.setName(name);
		// Fill in the amount
		double amount = paymentClassification.calculatePay();
		paycheck.setAmount(amount);
		// Fill in the disposition
		String disposition = paymentMethod.getDisposition();
		paycheck.setDisposition(disposition);
	}

}
