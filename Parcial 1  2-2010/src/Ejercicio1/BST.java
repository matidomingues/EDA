package Ejercicio1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BST<T> implements BinarySearchTree<T> {
	private Node root;
	private Comparator<? super T> cmp;

	public BST(Comparator<? super T> cmp) {
		this.root = null;
		this.cmp = cmp;
	}

	public void add(T value) {
		root = add(root,null, null, value);
	}

	private Node add(Node node, Node der, Node izq, T value) {
		if(node == null || node.equals(der) || node.equals(izq)){
			return new Node(value, izq,der);
		}
		if(cmp.compare(node.value, value)<0){
			node.right = add(node.right,der,node,value);
		}else if (cmp.compare(node.value, value)>0){
			node.left = add(node.left,node,izq,value);
		}
		return node;
	}
	
	public List<T> getInOrder(){
		List<T> list = new LinkedList<T>();
		getInOrder(root,null,null, list);
		return list;
		
	}

	private void getInOrder(Node head, Node der, Node izq,List<T> list){
		if(head == null || head.equals(der) || head.equals(izq)){
			return;
		}
		getInOrder(head.left, head, izq,list);
		list.add(head.value);
		getInOrder(head.right,der,head,list);
	}
	
	private class Node {
		T value;
		Node left;
		Node right;

		public Node(T value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}