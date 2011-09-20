package Ejercicio3;

import java.util.LinkedList;
import java.util.List;


public class BST<T> {
	/**
	 * 12:01 - 12:13
	 */
	
	Node tree;
	
	public List<T> getInOrder(int inf, int sup) {
		List<T> list = new LinkedList<T>();
		getInOrder(tree, inf, sup, list);
		return list;
	}

	private int getInOrder(Node tree, int inf, int sup, List<T> list) {
		int index;
		if (tree == null) {
			return 0;
		}

		index = getInOrder(tree.left, inf, sup, list);
		index++;
		if (inf <= index && sup >= index) {
			list.add(tree.value);
		}
		if (sup == index) {
			return index;
		}
		getInOrder(tree.right, inf, sup, list);
		return index;

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
