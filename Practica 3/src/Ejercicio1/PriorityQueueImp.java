package Ejercicio1;

import java.util.NoSuchElementException;

public class PriorityQueueImp<T> implements PriorityQueue<T> {

	private Node<Queue<T>> head = null;

	@Override
	public void enqueue(T elem, int priority) {
		if (priority < 0) {
			return;
		}
		if (head == null) {
			head = new Node<Queue<T>>(new Queue<T>(elem), priority, null);
		} else {
			Node<Queue<T>> aux = head;
			Node<Queue<T>> aux2 = null;
			while (aux != null) {
				if (head.getPriority() == priority) {
					(head.getData()).push(elem);
					return;
				} else if (head.getPriority() > priority) {
					if (aux2 == null) {
						head = new Node<Queue<T>>(new Queue<T>(elem), priority,
								head);
					} else {
						aux2.setNext(new Node<Queue<T>>(new Queue<T>(elem),
								priority, aux));
					}
					return;
				} else {
					aux2 = aux;
					aux = aux.getNext();
					if(aux == null){
						aux2.setNext(new Node<Queue<T>>(new Queue<T>(elem),priority,null));
					}
				}
			}
		}

	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T aux = (head.getData()).pop();
		if ((head.getData()).isEmpty()) {
			head = head.getNext();
		}
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
