package menus;

import main.CoffeeMachine;

public class MenuMain extends MenuBase {

	public MenuMain(MenuBase caller, CoffeeMachine coffeeMachine) {
		super(caller, coffeeMachine);
	}

	protected void print() {
		console.println("\tMENÚ PRINCIPAL");
		console.println("\t==============\n");
		console.println(" 1 - Comprar bebida");
		console.println(" 2 - Menú administración");
		console.println(" 0 - Salir");
	}

	protected void executeOption(int option) {
		switch (option) {
		case 0:
			console.println(" Apagando la máquina de café...");
			break;

		case 1:
			showBuyDrinkMenu();
			break;

		case 2:
			showAdminMenu();
			break;
		}
	}

	private void showBuyDrinkMenu() {
		MenuDrink drinkMenu = new MenuDrink(this, coffeeMachine);
		drinkMenu.show();
	}

	private void showAdminMenu() {
		MenuAdmin adminMenu = new MenuAdmin(this, coffeeMachine);
		adminMenu.show();
	}

	@Override
	protected boolean validOption(int option) {
		return option <= 2;
	}

	@Override
	protected boolean leaveMenuOption(int option) {
		return true;
	}
}
