package Ejercicio1;

public class Stack<V> {

	Node<V> head = null;

	public void add(V data, int version) {
		if (head == null) {
			head = new Node<V>(data, null, version);
		} else {
			head = new Node<V>(data, head, version);
		}
	}

	public V getData(int version) {
		Node<V> aux = head;
		while (aux != null) {
			if (aux.getVersion() <= version) {
				return aux.getData();
			}
			aux = aux.getSig();

		}
		return null;
	}

	private static class Node<V> {
		V data;
		int version;
		Node<V> sig;

		public Node(V data, Node<V> sig, int version) {
			this.data = data;
			this.sig = sig;
			this.version = version;
		}

		public Node<V> getSig() {
			return this.sig;
		}

		public V getData() {
			return this.data;
		}

		public int getVersion() {
			return this.version;
		}
	}
}
