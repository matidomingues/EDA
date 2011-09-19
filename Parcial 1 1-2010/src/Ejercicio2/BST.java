package Ejercicio2;

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

	public boolean contains(T value) {
		return contains(root, value);
	}

	public void remove(T value) {
		
	}
	
	private Node remove(T value, Node tree){
		if(tree == null){
			return null;
		}
		if(tree.value.equals(value)){
			if(tree.left == null && tree.right == null){
				return null;
			}else if(tree.left == null){
				return tree.right;
			}else if(tree.right == null){
				return tree.left;
			}else{
				if(cmp.compare(tree.left.value,	tree.right.value)>0){
					addR(tree.right, tree.left);
					return tree.right;
				}else{
					addR(tree.left, tree.right);
					return tree.left;
				}
			}
		}
		tree.left = remove(value,tree.left);
		tree.right = remove(value,tree.right);
		
		
		
		
		return tree;
	}
	
	private void addR(Node head, Node data){
		
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
		T value;
		Node left;
		Node right;

		Node(T value) {
			this.value = value;
		}
	}
}
