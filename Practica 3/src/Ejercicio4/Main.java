package Ejercicio4;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parse test = new Parse();
		try {
			System.out.println(test.parser("ParseTest"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
