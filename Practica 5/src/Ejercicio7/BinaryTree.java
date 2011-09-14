package Ejercicio7;

public class BinaryTree<T extends Comparable<? super T>> implements
		BinarySearchTree<T> {

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

	@Override
	public void add(T key) {
		add(head, key);

	}

	private Tree<T> add(Tree<T> tree, T key) {
		if (tree == null) {
			return new Tree<T>(key, null, null);
		}
		if (key.compareTo(tree.getData()) == -1) {
			tree.setLeft(add(tree.getLeft(), key));
		} else if (key.compareTo(tree.getData()) == 1) {
			tree.setRight(add(tree.getRight(), key));
		}
		return tree;

	}

	@Override
	public void remove(T key) {
		head = remove(head, key);

	}

	private Tree<T> remove(Tree<T> tree, T key) {
		if (tree == null) {
			return null;
		}
		if (key.equals(tree.getData())) {
			if (tree.getLeft() != null && tree.getRight() != null) {
				T auxkey = findMin(tree.getRight());
				remove(tree, auxkey);
				tree.setData(auxkey);
				return tree;
			} else if (tree.getLeft() != null) {
				return tree.getLeft();
			} else if (tree.getRight() != null) {
				return tree.getRight();
			} else {
				return null;
			}

		}
		if (key.compareTo(tree.getData()) < 0) {
			tree.setLeft(remove(tree.getLeft(), key));
		} else {
			tree.setRight(remove(tree.getRight(), key));
		}
		return tree;
	}

	private T findMin(Tree<T> tree) {
		if (tree.getLeft() == null) {
			return tree.getData();
		}
		return findMin(tree.getLeft());
	}

	@Override
	public boolean contains(T key) {
		return contains(head, key);
	}

	private boolean contains(Tree<T> tree, T key) {
		if (tree == null) {
			return false;
		} else if (tree.getData().equals(key)) {
			return true;
		}
		return contains(tree.getLeft(), key) || contains(tree.getRight(), key);
	}

	@Override
	public int size() {
		return size(head);
	}

	private int size(Tree<T> tree) {
		if (tree == null) {
			return 0;
		}
		return 1 + size(tree.getRight()) + size(tree.getLeft());
	}

	@Override
	public int findKey(T key) {
		return findKey(head, key);
	}

	private int findKey(Tree<T> tree, T key) {
		int aux;
		if (tree == null) {
			return -1;
		}
		if (tree.getData().equals(key)) {
			return 0;
		}
		if (key.compareTo(tree.getData()) < 0) {
			aux = findKey(tree.getLeft(), key);
		} else {
			aux = findKey(tree.getRight(), key);
		}
		if (aux == -1) {
			return -1;
		}
		return aux + 1;
	}

	@Override
	public int getLeaf() {
		if(head == null){
			return 0;
		}
		return getLeaf(head);
	}

	private int getLeaf(Tree<T> tree){
		if(tree == null){
			return 1;
		}
		return getLeaf(tree.getLeft())+getLeaf(tree.getRight());
	}
	@Override
	public T getMax() {
		if(head == null){
			return null;
		}
		return getMax(head);
	}
	
	private T getMax(Tree<T> tree){
		if(tree.getRight() == null){
			return tree.getData();
		}
		return getMax(tree.getRight());
	}
	@Override
	public void printAntescesor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printDescendants() {
		// TODO Auto-generated method stub

	}

}