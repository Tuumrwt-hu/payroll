package payroll.method;

import payroll.PaymentMethod;

public class MailMethod extends PaymentMethod {

	private String address;

	public MailMethod(String address) {
		this.address = address;
	}

	public Object getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

}
