package payroll.classification;

import java.util.LinkedHashMap;
import java.util.Map;

import payroll.PaymentClassification;

public class HourlyClassification extends PaymentClassification {

	private double hourlyRate;
	private Map<String, TimeCard> timeCards = new LinkedHashMap<>();

	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public TimeCard getTimeCardOfDate(String date) {
		return timeCards.get(date);
	}

	public void addTimeCard(TimeCard tc) {
		timeCards.put(tc.getDate(), tc);
	}

	@Override
	public double calculatePay() {
		// TODO Auto-generated method stub
		return 0;
	}

}
