package Ejercicio1;

public class Main {

	public static void main(String[] args) {
		Integer[] data = { 1, 6, 2, 62, 2512, 26263, 234, 41, 155, 672, 2, 7,
				123, 78, 1, 0, 0, 2133, 57, 98, 342, 3 };
		Numbers.sort(data);
		for (Integer i : data) {
			System.out.println(i);
		}
	}

}
