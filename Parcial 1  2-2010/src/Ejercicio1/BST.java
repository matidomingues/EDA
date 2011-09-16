package Ejercicio1;

import java.util.Comparator;

public class BST<T> implements BinarySearchTree<T> {
	private Node root;
	private Comparator<? super T> cmp;

	public BST(Comparator<? super T> cmp) {
		this.root = null;
		this.cmp = cmp;
	}

	public void add(T value) {
		root = add(root, value);
	}

	private Node add(Node node, T value) {
		return null;
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