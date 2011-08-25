package Ejercicio1;

public class BubbleSort<T extends Comparable<T>> {

	public void sort(T array[]) {
		T aux;
		long start, end;
		start = System.currentTimeMillis();
		for (int b = 0; b < array.length; b++) {
			for (int a = b + 1; a + 1 < array.length - b; a++) {
				if (array[a].compareTo(array[a + 1]) == -1) {
					aux = array[a];
					array[a] = array[a + 1];
					array[a + 1] = aux;
				}
			}
		}
		end = System.currentTimeMillis();
		System.out.println("Tarda " + (end - start) + "ms");
	}
}
