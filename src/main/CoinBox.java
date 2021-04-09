package main;

public class CoinBox {
	private final int INITIAL_COIN_UNITS = 5;

	private CoinCollection coins;
	private RefundAlgorithm refundAlgorithm;

	public CoinBox() {
		coins = initCoins();
		refundAlgorithm = new RefundAlgorithm();
	}

	private CoinCollection initCoins() {
		Coin[] coins = new Coin[5];

		coins[0] = new Coin(100, INITIAL_COIN_UNITS);
		coins[1] = new Coin(50, INITIAL_COIN_UNITS);
		coins[2] = new Coin(20, INITIAL_COIN_UNITS);
		coins[3] = new Coin(10, INITIAL_COIN_UNITS);
		coins[4] = new Coin(5, INITIAL_COIN_UNITS);

		return new CoinCollection(coins);
	}

	public Coin[] getCoins() {
		return coins.getCoins();
	}

	/**
	 * Método que incrementa las monedas del cajetín
	 */
	public void add(Coin coin) {
		coins.add(coin);
	}

	/**
	 * Método que devuelve la colección de monedas que componen el cambio
	 * 
	 * @param cents Valor en céntimos del cambio que ha de devolver
	 */
	public Coin[] refund(int cents) {
		return refundAlgorithm.refund(cents, coins).getCoins();
	}

	/**
	 * Método que comprueba si el cajetín tiene monedas para el devolver
	 * 
	 * @param cents Valor en céntimos del cambio que ha de devolver
	 * @return Devuelve 'true' si la máquina tiene cambio, y 'false' en caso
	 *         contrario
	 */
	public boolean hasRefund(int cents) {
		CoinCollection refund = refundAlgorithm.refund(cents, coins.cloneCoins());

		return refund.getCents() == cents;
	}

}
