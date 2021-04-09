package main;

public class Drink {

	public static final float MIN_PRICE = 0.20f;

	/**
	 * Nombre de la bebida
	 */
	private String name;

	/**
	 * Precio de la bebida
	 */
	private int price;

	/**
	 * Unidades de cada bebida
	 */
	private int units;

	public Drink(String name, int price, int units) {
		super();

		this.name = name;
		this.price = price;
		this.units = units;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
}
