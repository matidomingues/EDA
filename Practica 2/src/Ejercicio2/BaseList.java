package Ejercicio2;

public class BaseList<T> {
	private Node<T> first;
	private Node<T> last;

	public BaseList() {
		this.first = null;
		this.last = null;
	}

	public T getFirst() {
		return first.getHead();
	}

	public void add(T elem) {
		if (first == null) {
			first = last = new Node<T>(elem, null);
		} else {
			last.setTail(new Node<T>(elem, null));
			last = last.getTail();
		}

	}

	public void addR(T elem) {
		if (last == null) {
			last = first = new Node<T>(elem, null);
		} else {
			first = new Node<T>(elem, first);
		}
	}

	public boolean remove(T elem) {
		return false;
	}

	public int count(Node<T> head, Condition<T> comp) {
		int count;
		if (head == null) {
			return 0;
		}
		count = count(head.getTail(), comp);
		if (comp.evaluate(head.getHead())) {
			return count + 1;
		}
		return count;
	}

	public BaseList<T> filter(BaseList<T> data, Condition<T> comp) {
		return filter(data.first, comp);
	}

	private BaseList<T> filter(Node<T> head, Condition<T> comp) {
		BaseList<T> list;
		if (head == null) {
			return new BaseList<T>();
		}
		list = filter(head.getTail(), comp);
		if (comp.evaluate(head.getHead())) {
			list.addR(head.getHead());
		}
		return list;
	}

	public <S> BaseList<S> map(Node<T> head, Func<T, S> comp) {
		BaseList<S> list;
		if (head == null) {
			return new BaseList<S>();
		}
		list = map(head.getTail(), comp);
		list.addR(comp.resp(head.getHead()));
		return list;
	}

	public <S> S inject(Node<T> head, Func2<T, S> comp, S seed) {
		if (head == null) {
			return seed;
		}
		return inject(head.getTail(), comp, comp.inject(head.getHead(), seed));

	}

	private static class Node<T> {
		private T head;
		private Node<T> tail;

		public Node(T data, Node<T> next) {
			this.head = data;
			this.tail = next;
		}

		public T getHead() {
			return head;
		}

		public Node<T> getTail() {
			return tail;
		}

		public void setHead(T data) {
			this.head = data;
		}

		public void setTail(Node<T> tail) {
			this.tail = tail;
		}
	}
}
