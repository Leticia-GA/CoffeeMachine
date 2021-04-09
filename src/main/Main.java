package main;

/**
 * Proyecto que simula una m�quina vending de caf�
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
