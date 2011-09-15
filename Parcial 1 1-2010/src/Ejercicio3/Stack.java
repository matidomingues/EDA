package Ejercicio3;

public class Stack {

	Node head = null;

	public void push(String data) {
		if (head == null) {
			head = new Node(data, null);
		} else {
			head = new Node(data, head);
		}
	}

	public String pop() {
		if (head == null) {
			return null;
		}
		String aux = head.data;
		head = head.sig;
		return aux;
	}

	private class Node {
		String data;
		Node sig;

		public Node(String data, Node sig) {
			this.data = data;
			this.sig = sig;
		}
	}
}
