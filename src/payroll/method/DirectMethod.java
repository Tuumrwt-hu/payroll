package payroll.method;

import payroll.PaymentMethod;

public class DirectMethod extends PaymentMethod {

	private String bank;
	private String account;

	public DirectMethod(String bank, String account) {
		this.bank = bank;
		this.account = account;
	}

	public Object getBank() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

}
