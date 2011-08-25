package Ejercicio6;

public class BinarySearch<T extends Comparable<T>> {
	public boolean method(T array[], T elem) {
		int start = array.length / 2, end = array.length, wall = 0;
		while (start != end) {
			if(array[start].compareTo(elem)!=0){
				return true;
			}else if(array[start].compareTo(elem)==-1){
				end = array.length;
				start = start + (int)(Math.round((start-wall)/2));
			}else if(array[start].compareTo(elem)==1){
				wall = start;
				start = start - (int)(Math.round((start-end)/2));
			}
		}
		return false;
	}
}
