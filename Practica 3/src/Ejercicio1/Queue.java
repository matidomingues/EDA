package Ejercicio1;

public class Queue<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size = 0;;

	public Queue(T elem){
		head = tail = new Node<T>(elem,null);
	}
	
	public void push(T elem) {
		if (isEmpty()) {
			head = tail = new Node<T>(elem, null);
		} else {
			tail.setNext(new Node<T>(elem, tail.getNext()));
			tail = tail.getNext();
		}
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		}
		T aux = head.getElem();
		head = head.getNext();
		size--;
		return aux;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public int getsize() {
		return size;
	}

	private static class Node<T> {
		T elem;
		Node<T> next;

		public Node(T elem, Node<T> sig) {
			this.next = sig;
			this.elem = elem;
		}

		public T getElem() {
			return elem;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}
}
