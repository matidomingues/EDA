package Ejercicio2;

public class SortedListImp<T extends Comparable<? super T>> implements
		SortedList<T> {

	Node<T> head = null;
	Stack<Node<T>> undos = new Stack<Node<T>>();

	/**
	 * 11:01 - 11: 52
	 */

	@Override
	public void add(T elem) {
		head = add(head, elem);
	}

	private Node<T> add(Node<T> list, T elem) {
		if (list == null) {
			Node<T> aux = new Node<T>(elem, null, null);
			undos.push(aux);
			return aux;
		}
		if (list.getElem().compareTo(elem) > -1) {
			Node<T> aux = new Node<T>(elem, list,null);
			list.setBefore(aux);
			undos.push(aux);
			return aux;
		}
		Node<T> aux = add(list.getSig(), elem);
		aux.setBefore(list);
		list.setSig(aux);
		return list;
	}

	@SuppressWarnings("unused")
	@Override
	public void undo() {
		Node<T> aux = undos.pop();
		if(aux.equals(head)){
			head = aux.getSig();
			head.setBefore(null);
			return;
		}
		if(aux == null){
			return;
		}
		if(aux.getBefore()!= null){
			aux.getBefore().setSig(aux.getSig());
		}
		if(aux.getSig() != null){
			aux.getSig().setBefore(aux.getBefore());
		}
	}

	@Override
	public void print() {
		Node<T> aux = head;
		while (aux != null) {
			System.out.print(aux.getElem() + " ");
			aux = aux.getSig();
		}
		System.out.println(" ");
	}

	private static class Node<T> {

		Node<T> sig;
		Node<T> before;
		T data;

		public Node(T data, Node<T> sig, Node<T> before) {
			this.data = data;
			this.sig = sig;
			this.before = before;
		}

		public void setSig(Node<T> sig) {
			this.sig = sig;
		}

		public void setBefore(Node<T> before) {
			this.before = before;
		}

		public Node<T> getSig() {
			return this.sig;
		}

		public Node<T> getBefore() {
			return this.before;
		}

		public T getElem() {
			return this.data;
		}
	}

}
