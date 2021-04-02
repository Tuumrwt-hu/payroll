package payroll;

public class Paycheck {

	private int empId;
	private String name;
	private double amount;
	private String disposition;

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

}
