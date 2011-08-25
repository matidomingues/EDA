package Ejercicio6;

public class Union<T extends Comparable<T>> {
	/**
	 * Gets the Union between two elements. Complexity: O(N^2).
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	public T[] getUnion1(T array1[], T array2[]) {
		
		@SuppressWarnings("unchecked")
		T[] array3 = (T[]) new Comparable[Math.min(array1.length, array2.length)];
		int w = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int k = 0; k < array2.length; k++) {
				if (array1[i] == array2[k]) {
					array3[w++] = array1[i];
				}
			}
		}
		return array3;
	}

	/**
	 * Returns the Union between 2 Arrays by using BinarySearch to find the
	 * ocurrence. Complexity: O(N log(N)).
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T[] getUnion2(T array1[], T array2[]) {
		T[] array3 = (T[]) new Comparable[Math.min(array1.length, array2.length)];
		BinarySearch<T> search = new BinarySearch<T>();
		int w = 0;
		for (int i = 0; i < array1.length; i++) {
			if (search.method(array2, array1[i])) {
				array3[w] = array1[i];
			}
		}
		return array3;
	}
	
	/**
	 * Gets the Union between two ordered Arrays. Complexity: O(N).
	 * @param array1
	 * @param array2
	 * @return
	 */
	public T[] getUnion3(T array1[], T array2[]) {
		@SuppressWarnings("unchecked")
		T[] array3 = (T[]) new Comparable[Math.min(array1.length, array2.length)];
		int a = 0, b = 0,c=0;
		while (a < array1.length && b < array2.length) {
			if(array1[a] == array2[b]){
				array3[c++] = array1[a];
			}
			if(a == b){
				a++;
				b++;
			}else if(a>b){
				b++;
			}else if(a<b){
				a++;
			}
		}
		return array3;
	}
}
