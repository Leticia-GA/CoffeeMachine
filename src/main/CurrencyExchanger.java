package main;

import java.text.DecimalFormat;

public class CurrencyExchanger {

	public String toEuros(int cents) {
		DecimalFormat eurosFormat = new DecimalFormat("0.00");
		float euros = (float) cents / 100;

		return eurosFormat.format(euros) + " €";
	}

}
