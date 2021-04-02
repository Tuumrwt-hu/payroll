package payroll.method;

import payroll.PaymentMethod;

public class DirectMethod extends PaymentMethod {

	private String bank;
	private String account;

	public DirectMethod(String bank, String account) {
		this.bank = bank;
		this.account = account;
	}

	public String getBank() {
		return bank;
	}

	public String getAccount() {
		return account;
	}

	@Override
	public String getDisposition() {
		// TODO Auto-generated method stub
		return null;
	}

}
