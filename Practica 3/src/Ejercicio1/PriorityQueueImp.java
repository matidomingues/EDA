package Ejercicio1;

import java.util.NoSuchElementException;

public class PriorityQueueImp<T> implements PriorityQueue<T> {

	private Node<T> head = null;

	@Override
	public void enqueue(T elem, int priority) {
		if (priority < 0) {
			return;
		}
		if (head == null) {
			head = new Node<T>(elem, priority, null);
		} else {
			Node<T> aux = head;
			Node<T> before = null;
			while (aux != null) {
				if (aux.getPriority() <= priority) {
					before = aux;
					aux = aux.getNext();
				} else {
					if (before == null) {
						head = new Node<T>(elem, priority, head);
					} else {
						before.setNext(new Node<T>(elem, priority, aux));
					}
					return;
				}
			}
			if (before != null) {
				before.setNext(new Node<T>(elem, priority, null));
			}
		}

	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T aux = head.getData();
		head = head.getNext();
		return aux;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	private static class Node<T> {
		T data;
		Node<T> next;
		int priority;

		public Node(T data, int priority, Node<T> sig) {
			this.data = data;
			this.priority = priority;
			this.next = sig;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public int getPriority() {
			return priority;
		}

	}
}
