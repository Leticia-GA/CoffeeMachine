package main;

/**
 * Proyecto que simula una máquina vending de café
 * 
 * @author Leticia
 *
 */

public class Main {
	private static void initCoffeeMachine() {
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		coffeeMachine.turnOn();
	}

	public static void main(String[] args) {
		initCoffeeMachine();
	}
}
