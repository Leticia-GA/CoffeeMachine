package main;

import java.util.Scanner;

public class Console {
	private Scanner reader;

	public Console() {
		reader = new Scanner(System.in);
	}

	public void println(String message) {
		System.out.println(message);
	}

	public String readString() {
		return reader.next();
	}

	public int readInt() {
		int number;

		do {
			while (!reader.hasNextInt()) {
				println(" Debes introducir un número entero");
				reader.next();
			}

			number = reader.nextInt();

			validatePositive(number);
		} while (number < 0);

		return number;
	}

	public float readDecimal() {
		float number;

		do {
			while (!reader.hasNextFloat()) {
				println(" Debes introducir un número decimal separado por coma");
				reader.next();
			}

			number = reader.nextFloat();

			validatePositive(number);
		} while (number < 0);

		return number;
	}

	private void validatePositive(float number) {
		if (number < 0) {
			println(" Debes introducir un número positivo");
		}
	}
}
