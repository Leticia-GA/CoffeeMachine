package menus;

import main.CoffeeMachine;
import main.Coin;
import main.Drink;

public class MenuDrink extends MenuBase {
	/**
	 * N�mero de opciones previas al men� de bebidas, se usar� para deducir la
	 * bebida seleccionada
	 */
	private final int NUM_DRINK_MENU_PREVIOUS_OPTIONS = 3;

	public MenuDrink(MenuBase caller, CoffeeMachine coffeeMachine) {
		super(caller, coffeeMachine);
	}

	@Override
	protected void print() {
		printMainOptions();
		printDrinksMenu();
	}

	private void printMainOptions() {
		console.println("\tCOMPRAR BEBIDA");
		console.println("\t==============\n");
		console.println(showCredit());
		console.println(" 1 - Introducir monedas");
		console.println(" 2 - Devolver monedas");
		console.println(" 0 - Volver al men� principal\n");
	}

	/**
	 * Imprime las bebidas disponibles
	 */
	private void printDrinksMenu() {
		for (int i = 0; i < coffeeMachine.getDrinks().length; i++) {
			Drink current = coffeeMachine.getDrinks()[i];
			console.println(" " + getDrinkData(current, i + NUM_DRINK_MENU_PREVIOUS_OPTIONS));
		}
	}

	/**
	 * Devuelve los datos de la bebida tal y como se mostrar�n en el men� principal
	 */
	private String getDrinkData(Drink current, int numDrink) {
		return numDrink + " - " + current.getName() + " - precio: " + exchanger.toEuros(current.getPrice())
				+ " / unidades: " + current.getUnits();
	}

	@Override
	protected boolean validOption(int option) {
		return option <= coffeeMachine.getDrinks().length + NUM_DRINK_MENU_PREVIOUS_OPTIONS - 1;
	}

	@Override
	protected void executeOption(int option) {
		switch (option) {
		case 0:
			backward();
			break;

		case 1:
			showInsertCoinMenu();
			break;

		case 2:
			refund(coffeeMachine.getCredit());
			break;

		default:
			buyDrink(option - NUM_DRINK_MENU_PREVIOUS_OPTIONS);
		}
	}

	private void showInsertCoinMenu() {
		MenuInsertCoin insertCoinMenu = new MenuInsertCoin(this, coffeeMachine);
		insertCoinMenu.show();
	}

	/**
	 * Obtiene del cajet�n la colecci�n de monedas a devolver, las muestra al
	 * usuario y vuelve a poner el cr�dito a 0
	 * 
	 * @param amount Valor en c�ntimos del cambio que ha de devolver
	 */
	private void refund(int amount) {
		Coin[] refund = coffeeMachine.getCoinBox().refund(amount);

		for (Coin coin : refund) {
			console.println(" Devolviendo " + coin.getUnits() + " moneda/s de " + exchanger.toEuros(coin.getCents()));
		}

		if (coffeeMachine.getCredit() == 0) {
			console.println(" Cr�dito 0. No hay ninguna moneda que devolver");
		}

		console.println("");

		coffeeMachine.setCredit(0);
	}

	/**
	 * Comprueba que la selecci�n del usuario es correcta, sirve la bebida y
	 * devuelve el cambio. En caso de ser incorrecta muestra un mensaje de error.
	 */
	private void buyDrink(int numDrink) {
		Drink drink = coffeeMachine.getDrinks()[numDrink];

		if (coffeeMachine.getCredit() < drink.getPrice()) {
			console.println(" Cr�dito insuficiente, introduzca m�s monedas\n");
			return;
		}

		int refund = coffeeMachine.getCredit() - drink.getPrice();

		if (!coffeeMachine.getCoinBox().hasRefund(refund)) {
			console.println(" No hay cambio para la compra de esta bebida\n");
			return;
		}

		if (drink.getUnits() == 0) {
			console.println(" No hay bebidas de esa selecci�n\n");
			return;
		}

		console.println(" Sirviendo " + drink.getName() + "...\n");

		coffeeMachine.buy(drink);
		refund(refund);
	}

	@Override
	protected boolean leaveMenuOption(int option) {
		return option == 0 || option == 1;
	}
}
