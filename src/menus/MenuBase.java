package menus;

import main.Console;
import main.CoffeeMachine;
import main.CurrencyExchanger;

abstract public class MenuBase {
	protected Console console;
	protected MenuBase caller;
	protected CoffeeMachine coffeeMachine;
	protected CurrencyExchanger exchanger;

	public MenuBase(MenuBase caller, CoffeeMachine coffeeMachine) {
		this.console = new Console();
		this.caller = caller;
		this.coffeeMachine = coffeeMachine;
		this.exchanger = new CurrencyExchanger();
	}

	/**
	 * M�todo que muestra el men�, ejecuta la opci�n introducida por el usuario, y
	 * si no es una opci�n de navegaci�n entre men�s, vuelve a imprimirlo
	 */
	public void show() {
		print();

		int option = readOption();

		while (!leaveMenuOption(option)) {
			executeOption(option);
			print();
			option = readOption();
		}

		executeOption(option);
	}

	/**
	 * Determina si la opci�n introducida por el usuario le hace seguir en el mismo
	 * men� o irse a otro
	 */
	protected abstract boolean leaveMenuOption(int option);

	/**
	 * Vuelve al men� anterior
	 */
	protected void backward() {
		if (caller != null) {
			caller.show();
		}
	}

	/**
	 * Imprime las opciones del men�
	 */
	protected abstract void print();

	/**
	 * Lee la opci�n introducida por el usuario y comprueba si es v�lida
	 */
	protected int readOption() {
		int option = console.readInt();
		boolean validOption = validOption(option);

		while (!validOption) {
			console.println("Opci�n no v�lida. Introduzca una opci�n del men�");
			option = console.readInt();
			validOption = validOption(option);
		}

		return option;
	}

	/**
	 * Muestra el cr�dito en cada momento del usuario
	 */
	protected String showCredit() {
		return " Su cr�dito es de " + exchanger.toEuros(coffeeMachine.getCredit()) + "\n";
	}

	/**
	 * Comprueba si la opci�n del men� introducida es v�lida
	 */
	protected abstract boolean validOption(int option);

	protected abstract void executeOption(int option);
}
