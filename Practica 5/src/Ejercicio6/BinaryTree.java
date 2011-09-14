package Ejercicio6;

import java.util.Comparator;

public class BinaryTree<T extends Comparator<? super T>> implements BinarySearchTree<T>{

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
		add(head,key);
		
	}

	private Tree<T> add(Tree<T> tree, T key){
		if(tree == null){
			return new Tree<T>(key, null, null);
		}
		if(key.compare(key, tree.getData()) == -1){
			tree.setLeft(add(tree.getLeft(), key));
		}else if(key.compare(key, tree.getData())==1){
			tree.setRight(add(tree.getRight(), key));
		}
		return tree;
		
	}

	@Override
	public void remove(T key) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public boolean contains(T key) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}