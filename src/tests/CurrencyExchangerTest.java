package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.CurrencyExchanger;

class CurrencyExchangerTest {

	@Test
	void test() {
		CurrencyExchanger exchanger = new CurrencyExchanger();

		Assert.assertEquals("1,00 €", exchanger.toEuros(100));
		Assert.assertEquals("0,05 €", exchanger.toEuros(5));
		Assert.assertEquals("1,20 €", exchanger.toEuros(120));
	}

}
