package payroll.method;

import payroll.PaymentMethod;

public class MailMethod extends PaymentMethod {

	private String address;

	public MailMethod(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

}
