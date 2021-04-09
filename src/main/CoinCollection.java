package main;

import java.util.Arrays;

public class CoinCollection {
	private Coin[] coins;

	public CoinCollection(Coin[] coins) {
		this.coins = coins;
	}

	public Coin[] getCoins() {
		return coins;
	}

	/**
	 * Devuelve una copia de la colección de monedas del cajetín para operar con
	 * ellas sin que afecte a la colección en sí. Se utiliza en el algoritmo que
	 * comprueba si hay cambio en el cajetín, ya que afecta a la cantidad de
	 * unidades de la colección de monedas.
	 */
	public CoinCollection cloneCoins() {
		Coin[] cloneCoins = new Coin[coins.length];

		for (int i = 0; i < coins.length; i++) {
			Coin current = coins[i];
			cloneCoins[i] = new Coin(current.getCents(), current.getUnits());
		}

		return new CoinCollection(cloneCoins);
	}

	/**
	 * Método que añade una modeda incrementando las unidades en caso de existir o
	 * añadiéndola a la colección en caso contrario
	 */
	public void add(Coin coin) {
		boolean coinFound = false;

		for (int i = 0; i < coins.length; i++) {
			Coin current = coins[i];

			if (current.getCents() == coin.getCents()) {
				current.setUnits(current.getUnits() + coin.getUnits());
				coinFound = true;
				break;
			}
		}

		if (!coinFound) {
			coins = Arrays.copyOf(coins, coins.length + 1);
			coins[coins.length - 1] = coin;
		}
	}

	public int getCents() {
		int cents = 0;

		for (Coin coin : coins) {
			cents += coin.getCents() * coin.getUnits();
		}

		return cents;
	}
}
