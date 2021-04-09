package menus;

import main.CoffeeMachine;
import main.Coin;
import main.Drink;

public class MenuAdmin extends MenuBase {

	public MenuAdmin(MenuBase caller, CoffeeMachine coffeeMachine) {
		super(caller, coffeeMachine);
	}

	@Override
	protected void print() {
		console.println("\tMENÚ ADMINISTRACIÓN");
		console.println("\t===================\n");
		console.println(" 1 - Mostrar contenido de cajetines");
		console.println(" 2 - Modificar el precio de los productos");
		console.println(" 3 - Añadir productos");
		console.println(" 0 - Volver al menú principal");
	}

	@Override
	public boolean validOption(int option) {
		return option <= 3;
	}

	@Override
	protected void executeOption(int option) {
		switch (option) {
		case 0:
			backward();
			break;

		case 1:
			showCoinBoxContent();
			break;

		case 2:
			updateProducts();
			break;

		case 3:
			addDrink();
			break;
		}
	}

	private void showCoinBoxContent() {
		for (Coin coin : coffeeMachine.getCoinBox().getCoins()) {
			console.println(
					" El cajetín tiene " + coin.getUnits() + " monedas de " + exchanger.toEuros(coin.getCents()));
		}

		console.println("");
	}

	/**
	 * Recorre el array de bebidas y establece el precio de cada una de ellas en
	 * función de lo que introduzca el usuario
	 */
	private void updateProducts() {
		for (Drink drink : coffeeMachine.getDrinks()) {
			console.println(
					" El precio actual del " + drink.getName() + " es de " + exchanger.toEuros(drink.getPrice()));
			drink.setPrice(readDrinkPrice());
		}
	}

	/**
	 * Lee la información de la nueva bebida y la añade a la máquina de café
	 */
	private void addDrink() {
		String name = readDrinkName();
		int price = readDrinkPrice();

		Drink newDrink = new Drink(name, price, CoffeeMachine.INITIAL_DRINK_UNITS);
		coffeeMachine.addDrink(newDrink);
	}

	/**
	 * Lee el nombre del nuevo producto y comprueba que sea válido
	 */
	private String readDrinkName() {
		console.println(" Introduzca el nombre del producto");

		String name = console.readString();

		while (name == "") {
			console.println(" El nombre no puede estar vacío. Vuelva a introducir un nombre:");
			name = console.readString();
		}

		return name;
	}

	/**
	 * Lee el precio del nuevo producto y comprueba que sea válido
	 */
	private int readDrinkPrice() {
		console.println(" Introduzca el precio del producto:");

		float price = console.readDecimal();

		while (price < Drink.MIN_PRICE) {
			console.println(" El precio debe ser superior a " + Drink.MIN_PRICE + " €. Vuelva a introducir un precio:");
			price = console.readDecimal();
		}

		return Math.round(price * 100);
	}

	@Override
	protected boolean leaveMenuOption(int option) {
		return option == 0;
	}
}
