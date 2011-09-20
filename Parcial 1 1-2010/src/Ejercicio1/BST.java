package Ejercicio1;

import java.util.Comparator;

public class BST<T> implements BinarySearchTree<T> {
	private Node root;


	public BST(Comparator<? super T> cmp) {
		this.root = null;

	}

	public void add(T value) {
		root = add(root, value);
	}

	public boolean contains(T value) {
		return contains(root, value);
	}

	public void remove(T value) {
		root = remove(root, value);
	}

	private Node add(Node node, T value) {
		return null;
	}

	private boolean contains(Node node, T value) {
		return true;
	}

	private Node remove(Node node, T value) {
		return null;
	}

	private class Node {
		@SuppressWarnings("unused")
		T value;
		Node left;
		Node right;


	}

	/**
	 * 1:15 - 1:52
	 * 
	 * @param p
	 * @return
	 */
	public boolean isPBalanced(double p) {
		if (p < 1) {
			return false;
		}
		if (isPBalanced(root, p) >= 0) {
			return true;
		}
		return false;

	}

	private int isPBalanced(Node tree, double p) {
		int right, left;
		if (tree == null) {
			return 0;
		}
		right = isPBalanced(tree.right, p);
		left = isPBalanced(tree.left, p);
		if (left != -1 && right != -1) {
			if (left <= p * right + left && right <= p * right + left) {
				return 1 + left + right;
			}
		}
		return (-1);
	}

}
