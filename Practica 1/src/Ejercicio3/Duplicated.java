package Ejercicio3;

import java.util.HashSet;

public class Duplicated<T extends Comparable<T>> {
	/**
	 * This method checks if the array has duplicated entries by adding elements
	 * to a HashSet while checking if the element exists. Complexity: O(N)
	 * 
	 * @param array
	 * @return true in case the element is duplicated
	 * @return false in case there is no duplicated elements
	 */
	public boolean method1(T array[]) {
		HashSet<T> set = new HashSet<T>();
		for (int a = 0; a < array.length; a++) {
			if (set.contains(array[a])) {
				return true;
			} else {
				set.add(array[a]);
			}
		}
		return false;
	}

	/**
	 * Normal duplicated search algorithm. Complexity: O(N^2)
	 * 
	 * @param array
	 * @return true in case the element is duplicated
	 * @return false in case there is no duplicated elements
	 */
	public boolean method2(T array[]) {
		for (int a = 0; a < array.length; a++) {
			for (int b = a+1; b < array.length; b++) {
				if (array[a] == array[b]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks for duplicated entries in ordered arrays. Complexity: O(N).
	 * 
	 * @param array
	 * @return true if duplicated exists.
	 */
	public boolean method3(T array[]) {
		for (int a = 0; a + 1 < array.length; a++) {
			if (array[a] == array[a + 1]) {
				return true;
			}
		}
		return false;
	}
}
