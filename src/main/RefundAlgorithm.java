package main;

public class RefundAlgorithm {

	/**
	 * A partir de un número de céntimos a devolver y de una colección de monedas de
	 * la que obtener el cambio, devuelve las monedas que pueden componer el cambio.
	 */
	public CoinCollection refund(int cents, CoinCollection coins) {
		CoinCollection refund = new CoinCollection(new Coin[0]);

		for (Coin coin : coins.getCoins()) {
			do {
				if (coin.getUnits() > 0 && coin.getCents() <= cents) {
					coin.setUnits(coin.getUnits() - 1);
					refund.add(new Coin(coin.getCents(), 1));
					cents = cents - coin.getCents();
				} else {
					break;
				}
			} while (cents > 0);
		}

		return refund;
	}
}
