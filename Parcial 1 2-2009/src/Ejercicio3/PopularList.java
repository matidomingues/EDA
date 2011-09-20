package Ejercicio3;

public class PopularList<S,T> {

	Node<S,T> head = null;
	Node<S,T> tail = null;
	
	
	public void add(S key, T elem){
		if(head == null){
			head = tail = new Node<S,T>(key, elem, null);
		}else{
			tail.sig = new Node<S,T>(key,elem,null);
			tail = tail.sig;
		}
	}
	
	public T getElem(S key){
		getElem(head,key);
		if(head.key.equals(key)){
			return head.data;
		}else{
			return null;
		}
	}
	
	private Node<S,T> getElem(Node<S,T> tree, S key){
		if(tree == null){
			return null;
		}
		if(tree.key.equals(key)){
			Node<S,T> aux = tree.sig;
			tree.sig = head;
			head = tree;
			return aux;
		}
		tree.sig = getElem(tree.sig, key);
		return tree;
	}
	
	
	public static class Node<S,T>{
		S key;
		T data;
		Node<S,T> sig;
		
		public Node(S key, T data, Node<S,T> sig){
			this.key = key;
			this.data = data;
			this.sig = sig;
		}
		
		
	}
}
