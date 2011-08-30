package Ejercicio3;

public class Queue {

	private Node head = null;
	private Node tail = null;
	private int size = 0;;

	public void push(Integer time) {
		if (isEmpty()) {
			head = tail = new Node(time, null);
		} else {
			tail.setNext(new Node(time, tail.getNext()));
			tail = tail.getNext();
		}
		size++;
	}

	public Integer pop() {
		if (isEmpty()) {
			return null;
		}
		Integer aux = head.getTime();
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

	private static class Node {
		Integer time;
		Node next;

		public Node(Integer time, Node sig) {
			this.next = sig;
			this.time = time;
		}

		public Integer getTime() {
			return time;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
}
