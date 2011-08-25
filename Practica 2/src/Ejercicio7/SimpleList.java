package Ejercicio7;

public class SimpleList<T, S> {

	private Node<T, S> head;
	private Node<T, S> tail;

	public void add(T data, S key) {
		if (head == null) {
			tail = head = new Node<T, S>(data, key, null);
		} else {
			tail.setNext(new Node<T, S>(data, key, null));
			tail = tail.getNext();
		}
	}

	@SuppressWarnings("unused")
	public T searchById(S key) {
		Node<T, S> aux = head;
		Node<T, S> auxB = null;
		while (aux != null) {
			if (aux.getKey().equals(key)) {
				if (auxB != null) {
					auxB.setNext(aux.getNext());
				}
				aux.setNext(head);
				head = aux;
			}
		}
		if (aux == null) {
			return null;
		}
		return head.getData();
	}

	private static class Node<T, S> {
		S key;
		T data;
		Node<T, S> next;

		public Node(T data, S key, Node<T, S> next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}

		public void setNext(Node<T, S> next) {
			this.next = next;
		}

		public S getKey() {
			return key;
		}

		public T getData() {
			return data;
		}

		public Node<T, S> getNext() {
			return next;
		}
	}
}
