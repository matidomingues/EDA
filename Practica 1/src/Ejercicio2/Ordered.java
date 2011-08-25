package Ejercicio2;

public class Ordered<T extends Comparable<T>> {
	public boolean isInAscendentOrder(T array[]) {
		for (int a = 0; a+1 < array.length; a++) {
			if(array[a].compareTo(array[a+1])!=-1){
				return false;
			}
		}
		return true;
	}
}
