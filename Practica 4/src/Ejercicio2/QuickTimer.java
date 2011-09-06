package Ejercicio2;

public class QuickTimer {
	public static void main(String[] args) {
		int[] sizes = new int[] { 50000, 100000, 200000, 400000, 800000 };
		long start, time;
		for (int size : sizes) {
			start = System.currentTimeMillis();
			quickSort(createRandomArray(size));
			time = System.currentTimeMillis() - start;
			System.out.println("Size: " + size + " Time: " + time + " ms");
		}
	}

	private static void quickSort(int[] createRandomArray) {
		quickSort(createRandomArray, 0, createRandomArray.length - 1);

	}

	public static int[] createRandomArray(int size) {
		int[] ret = new int[size];
		for (int i = 0; i < size; i++) {
			ret[i] = (int) (Math.random() * 100);
		}
		return ret;
	}

	private static void quickSort(int[] array, int from, int to) {
		int size = to - from + 1;
		if (size <= 1) {
			return;
		}
		int pivot = ((int) (Math.random() * size) + from);
		swap(array, from, pivot);
		int k = from;
		for (int b = k + 1; b <= to; b++) {
			if (array[b] < array[from]) {
				swap(array, ++k, b);
			}
		}
		swap(array, from, k);
		quickSort(array, from, k - 1);
		quickSort(array, k + 1, to);
	}

	private static void swap(int[] array, int from, int to) {
		int aux = array[from];
		array[from] = array[to];
		array[to] = aux;
	}

}