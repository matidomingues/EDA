package Ejercicio1;

import java.util.Random;

public class Array {
	public static void main(String[] args) {
		int elements = 15000;
		Random num = new Random();
		Integer[] array = new Integer[elements];
		BubbleSort<Integer> sort = new BubbleSort<Integer>();
		for (int a = 0; a < elements; a++) {
			array[a] = new Integer(num.nextInt());
		}

		sort.sort(array);
		// print(array);
	}

	public static void print(Integer[] array) {
		for (Integer a : array) {
			System.out.print(a + " ");
		}
		System.out.println("");
	}
}
