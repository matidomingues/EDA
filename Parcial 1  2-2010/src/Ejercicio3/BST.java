package Ejercicio3;

import java.util.ArrayList;

import java.util.List;


public class BST<T> {
	/**
	 * 12:01 - 12:13
	 */

	Node tree;

	public List<T> getInOrder(int inf, int sup) {
		List<T> list = new ArrayList<T>();
		getInOrder(tree, inf, sup, list, 1);
		return list;
	}

	private int getInOrder(Node tree, Integer inf, Integer sup,
			List<T> list, int index) {
		if (tree == null) {
			return index;
		}

		index = getInOrder(tree.left, inf, sup, list, index);

		if (sup < index) {
			return index;
		}
		if (inf <= index) {
			list.add(tree.value);
		}
		index++;
		return getInOrder(tree.right, inf, sup, list, index);
	}

	private class Node {
		T value;
		Node left;
		Node right;


	}

}
