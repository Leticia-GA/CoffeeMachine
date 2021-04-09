package menus;

import main.CoffeeMachine;
import main.Coin;

public class MenuInsertCoin extends MenuBase {

	public MenuInsertCoin(MenuBase caller, CoffeeMachine coffeeMachine) {
		super(caller, coffeeMachine);
	}

	protected void print() {
		printInsertCoinOptions();
	}

	private void printInsertCoinOptions() {
		console.println("\tINTRODUZCA MONEDA");
		console.println("\t=================\n");
		console.println(showCredit());
		printInsertCoinMenu();
		console.println("\n 0 - Elegir bebida");

	}

	private void printInsertCoinMenu() {
		int numCoin = 1;

		for (Coin coin : coffeeMachine.getCoinBox().getCoins()) {
			console.println(getCoinData(coin, numCoin++));
		}
	}

	private String getCoinData(Coin coin, int numCoin) {
		return " " + numCoin + " - " + exchanger.toEuros(coin.getCents()) + " (El cajetín tiene " + coin.getUnits()
				+ " monedas)";
	}

	protected void executeOption(int option) {
		switch (option) {
		case 0:
			backward();
			break;

		default:
			insertCoin(option);
		}
	}

	/**
	 * Comprueba si la moneda seleccionada es válida, la añade al cajetín y aumenta
	 * el crédito de la máquina
	 */
	private void insertCoin(int numCoin) {
		Coin[] coins = coffeeMachine.getCoinBox().getCoins();

		if (numCoin >= 1 && numCoin <= coins.length) {
			int cents = coins[numCoin - 1].getCents();

			Coin coin = new Coin(cents, 1);
			coffeeMachine.getCoinBox().add(coin);
			coffeeMachine.setCredit(coffeeMachine.getCredit() + cents);
		} else {
			console.println(" La moneda no es válida. Introduzca una de las monedas del menú\n");
		}
	}

	@Override
	protected boolean leaveMenuOption(int option) {
		return option == 0;
	}

	@Override
	protected boolean validOption(int option) {
		return true;
	}
}
