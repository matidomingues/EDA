package Ejercicio2;

public class Stack<T> {

	Node<T> head = null;
	
	public void push(T data){
		head = new Node<T>(head, data);
	}
	
	public T pop(){
		T aux = head.getData();
		head = head.getSig();
		return aux;
	}
	
	private static class Node<T>{
		
		Node<T> sig = null;
		T data = null;
		
		public Node(Node<T> sig, T data){
			this.sig = sig;
			this.data = data;
		}
		
		public T getData(){
			return data;
		}
		
		public Node<T> getSig(){
			return this.sig;
		}
		
	}
}
