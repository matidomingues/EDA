package Ejercicio3;

import java.util.Iterator;

public class SimpleAisle<T> implements Iterable<T>{

	private Node<T> head = null;
	private Node<T> tail = null;
	
	public void add(T data){
		if (head == null) {
			head = tail = new Node<T>(data, null);
		} else {
			tail.setSig(new Node<T>(data, null));
			tail = tail.getSig();
		}
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T>{
		
		private Node<T> data = new Node<T>(null,head);
		@Override
		public boolean hasNext() {
			if(data == null){
				return false;
			}
			if(data.getSig()!= null){
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			data = data.getSig();
			return data.getAisle();
		}

		@Override
		public void remove() {
			return;
			
		}
		
	}
	
	private static class Node<T> {
		
		private T aisle;
		private Node<T> sig;

		public Node(T aisle, Node<T> sig) {
			this.aisle = aisle;
			this.sig = sig;
		}

		public T getAisle() {
			return aisle;
		}

		public void setAisle(T aisle) {
			this.aisle = aisle;
		}

		public Node<T> getSig() {
			return sig;
		}

		public void setSig(Node<T> sig) {
			this.sig = sig;
		}
	}
}
