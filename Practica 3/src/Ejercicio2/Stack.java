package Ejercicio2;

import java.util.NoSuchElementException;

public class Stack<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size=0;
	
	public void push(T elem) {
		if (head == null) {
			head = tail = new Node<T>(elem, null);
		} else {
			tail.setSig(new Node<T>(elem, null));
			tail = tail.getSig();
		}
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T aux = head.getElem();
		head = head.getSig();
		size--;
		return aux;
	}

	public int size(){
		return size;
	}
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	private static class Node<T> {

		T elem;
		Node<T> sig;

		public Node(T elem, Node<T> sig) {
			this.elem = elem;
			this.sig = sig;
		}

		public T getElem() {
			return elem;
		}

		public Node<T> getSig() {
			return sig;
		}

		public void setSig(Node<T> sig) {
			this.sig = sig;
		}

	}
}
