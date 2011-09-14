package Ejercicio1;

import java.util.Comparator;

public class BinaryTree<T extends Comparator<? super T>> {

	private Tree<T> head;

	static class Tree<T> {

		Tree<T> right;
		Tree<T> left;
		T data;

		public Tree(T data, Tree<T> right, Tree<T> left) {
			this.data = data;
			this.right = right;
			this.left = left;
		}

		public void setRight(Tree<T> right) {
			this.right = right;
		}

		public void setLeft(Tree<T> left) {
			this.left = left;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Tree<T> getRight() {
			return right;
		}

		public Tree<T> getLeft() {
			return left;
		}
	}

	public void add(T key) {
		add(head, key);

	}

	private Tree<T> add(Tree<T> tree, T key) {
		if (tree == null) {
			return new Tree<T>(key, null, null);
		}
		if (key.compare(key, tree.getData()) == -1) {
			tree.setLeft(add(tree.getLeft(), key));
		} else if (key.compare(key, tree.getData()) == 1) {
			tree.setRight(add(tree.getRight(), key));
		}
		return tree;

	}

	public void remove(T key) {
		// TODO Auto-generated method stub

	}

	public boolean contains(T key) {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Ejercicio 1 del parcial, en respuesta al punto B, la complejidad es de
	 * O(N)
	 * 
	 * @param tree
	 * @param N
	 * @return
	 */
	public boolean searchN(Tree<Integer> tree, int N) {
		if (tree == null) {
			return false;
		}
		N -= tree.getData();
		if (N < 0) {
			return false;
		} else if (N == 0) {
			if (tree.getLeft() == null && tree.getRight() == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return searchN(tree.getLeft(), N) || searchN(tree.getRight(), N);
		}
	}
}