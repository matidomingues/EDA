package Ejercicio3;

import java.util.List;

import Ejercicio1.BST.Node;

public class BST<T> {
	/**
	 * 12:01 - 12:13
	 */
	public List<T> getInOrder(int inf, int sup) {
		List<T> list;
		getInOrder(tree, inf, sup, list);
		return list;
	}

	private void getInOrder(Node tree, int inf, int sup, List<T> list) {
		if (tree == null) {
			return;
		}

		getInOrder(tree.left, inf, sup, list);
		if (inf <= 0 && sup >= 0) {
			list.add(tree.value);
		}
		if (sup == 0) {
			return;
		}
		getInOrder(tree.right, inf - 1, sup - 1, list);

	}

	private class Node {
		T value;
		Node left;
		Node right;

		Node(T value) {
			this.value = value;
		}
	}

}
