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
	 * Devuelve una copia de la colecci�n de monedas del cajet�n para operar con
	 * ellas sin que afecte a la colecci�n en s�. Se utiliza en el algoritmo que
	 * comprueba si hay cambio en el cajet�n, ya que afecta a la cantidad de
	 * unidades de la colecci�n de monedas.
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
	 * M�todo que a�ade una modeda incrementando las unidades en caso de existir o
	 * a�adi�ndola a la colecci�n en caso contrario
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
