package Ejercicio4;

/**
 * El mejor caso para agregar seria si desde una determinada parte de el final
 * ya se encuentra ordenado, entonces no lo evalua.
 * 
 * @author matdomin
 * 
 */

public class BubbleSort {
	public static void bubbleSort(int[] values) {
		int swapper = 0, swapperaux = 0;
		for (int i = 0; i < values.length; i++) {
			swapperaux = 0;
			for (int j = 0; j < values.length - (swapper + i) - 1; j++) {
				if (values[j + 1] < values[j]) {
					swap(values, j, j + 1);
					swapperaux = 0;
				} else {
					swapperaux++;
				}
			}
			swapper += swapperaux;
			if (swapper != 0) {
				swapper--;
			}
		}
	}

	private static void swap(int[] array, int from, int to) {
		int aux = array[from];
		array[from] = array[to];
		array[to] = aux;
	}
}
