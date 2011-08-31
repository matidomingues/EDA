package Ejercicio1;

public class Numbers {
	public static void sort(Integer[] data) {
		int[] sorter = new int[99999];
		int iter = 0;
		for (int i = 0; i < data.length; i++) {
			sorter[data[i]] += 1;
		}
		for (int i = 0; i < sorter.length; i++) {
			for(int b = 0 ; b<sorter[i];b++){
				data[iter++]= i;
			}
		}
	}
}
