package Ejercicio3;

public class BalancedTree<T> {

	public Tree<Integer> perfectBalance(int[] array) {

		return perfectWrapper(array, 0, array.length - 1);

	}

	private Tree<Integer> perfectWrapper(int[] array, int from, int to) {
		if (from > to) {
			return null;
		}
		int a = (int) ((to - from) / 2);
		return new Tree<Integer>(array[a], perfectWrapper(array, a+1, to),
				perfectWrapper(array, from, a-1));

	}

}
