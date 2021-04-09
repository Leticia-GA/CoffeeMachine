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
	 * Método que muestra el menú, ejecuta la opción introducida por el usuario, y
	 * si no es una opción de navegación entre menús, vuelve a imprimirlo
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
	 * Determina si la opción introducida por el usuario le hace seguir en el mismo
	 * menú o irse a otro
	 */
	protected abstract boolean leaveMenuOption(int option);

	/**
	 * Vuelve al menú anterior
	 */
	protected void backward() {
		if (caller != null) {
			caller.show();
		}
	}

	/**
	 * Imprime las opciones del menú
	 */
	protected abstract void print();

	/**
	 * Lee la opción introducida por el usuario y comprueba si es válida
	 */
	protected int readOption() {
		int option = console.readInt();
		boolean validOption = validOption(option);

		while (!validOption) {
			console.println("Opción no válida. Introduzca una opción del menú");
			option = console.readInt();
			validOption = validOption(option);
		}

		return option;
	}

	/**
	 * Muestra el crédito en cada momento del usuario
	 */
	protected String showCredit() {
		return " Su crédito es de " + exchanger.toEuros(coffeeMachine.getCredit()) + "\n";
	}

	/**
	 * Comprueba si la opción del menú introducida es válida
	 */
	protected abstract boolean validOption(int option);

	protected abstract void executeOption(int option);
}
