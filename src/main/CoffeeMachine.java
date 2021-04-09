package main;

import java.util.Arrays;

import menus.MenuMain;

public class CoffeeMachine {
	public static final int INITIAL_DRINK_UNITS = 5;

	private MenuMain mainMenu;
	private CoinBox coinBox;
	private Drink[] drinks;
	private int credit;

	public CoffeeMachine() {
		drinks = initDrinks();
		mainMenu = new MenuMain(null, this);
		coinBox = new CoinBox();
	}

	/**
	 * Inicializa la colección de bebidas que contendrá la máquina, el precio de
	 * cada una de ellas y sus unidades
	 */
	private Drink[] initDrinks() {
		Drink[] drinks = new Drink[3];

		drinks[0] = new Drink("Café solo", 50, INITIAL_DRINK_UNITS);
		drinks[1] = new Drink("Café con leche", 70, INITIAL_DRINK_UNITS);
		drinks[2] = new Drink("Té", 85, INITIAL_DRINK_UNITS);

		return drinks;
	}

	public Drink[] getDrinks() {
		return drinks;
	}

	public void addDrink(Drink newDrink) {
		drinks = Arrays.copyOf(drinks, drinks.length + 1);
		drinks[drinks.length - 1] = newDrink;
	}

	public CoinBox getCoinBox() {
		return coinBox;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * Muestra el menú principal
	 */
	public void turnOn() {
		mainMenu.show();
	}

	/**
	 * Extrae la bebida elegida por el usuario de la colección de bebidas
	 * 
	 * @param drink
	 */
	public void buy(Drink drink) {
		for (Drink currentDrink : drinks) {
			if (drink.getName().equals(currentDrink.getName())) {
				if (currentDrink.getUnits() > 0) {
					currentDrink.setUnits(currentDrink.getUnits() - 1);
				}

				break;
			}
		}
	}
}
