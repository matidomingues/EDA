package Ejercicio6;

public class RoundList<T> {

	private Node<T> head;
	private Node<T> tail;

	public void setTailNext(Node<T> next) {
		tail.setNext(next);
		tail = tail.getNext();
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Iterate<T> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterate<T> {

		Node<T> data = new Node<T>(null, head);
		Node<T> end = tail;
		int removed = 1;

		@Override
		public boolean hasNext() {
			if (data.getNext() == null) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			if (data.getData() != null) {
				end = data;
			}
			data = data.getNext();
			removed = 0;
			return data.getData();
		}

		@Override
		public void remove() {
			if (removed == 1) {
				throw new IllegalStateException();
			}
			data = data.getNext();
			end.setNext(data);
			removed = 1;
		}

		public void add(T elem) {
			end.setNext(new Node<T>(elem, data));
		}

	}

	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
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
	}
}
