package main;

public class Coin {
	/**
	 * Valor en céntimos de la moneda
	 */
	private int cents;

	/**
	 * Unidades que hay de cada moneda
	 */
	private int units;

	public Coin(int cents, int units) {
		this.cents = cents;
		this.units = units;
	}

	public int getCents() {
		return cents;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
}
