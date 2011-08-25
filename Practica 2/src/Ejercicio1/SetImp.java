package Ejercicio1;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetImp<T> implements Set<T> {

	private Node<T> head = null;
	private Node<T> tail = null;
	private int size;

	@Override
	public boolean add(T arg0) {
		if (this.contains(arg0)) {
			return false;
		}

		if (head == null) {
			head = new Node<T>(arg0, null, null);
			tail = head;
		} else {
			tail.setNext(new Node<T>(arg0, null, tail));
		}
		size++;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		for (T a : arg0) {
			this.add(a);
		}
		return true;
	}

	@Override
	public void clear() {
		for (T a : this) {
			remove(a);
		}
	}

	@Override
	public boolean contains(Object arg0) {
		for (T a : this) {
			if (a.equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		for (Object a : arg0) {
			if (!this.contains(a)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<T> {
		private Node<T> actualNode;

		MyIterator() {
			this.actualNode = new Node<T>(null, head, null);
		}

		@Override
		public boolean hasNext() {
			if (actualNode.next() == null) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			actualNode = actualNode.next();
			return actualNode.elem();
		}

		@Override
		public void remove() {
			if (actualNode.next() != null) {
				actualNode.next().setBefore(actualNode.getBefore());
			}
			if (actualNode.getBefore() != null) {
				actualNode.getBefore().setNext(actualNode.next());
			}
			size--;
		}

	}

	@Override
	public boolean remove(Object arg0) {
		Iterator<T> iter = this.iterator();
		while (iter.hasNext()) {
			if (iter.next().equals(arg0)) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		for (Object a : arg0) {
			this.remove(a);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		for (Object a : arg0) {
			if (!this.contains(a)) {
				this.remove(a);
			}
		}
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] a = new Object[size];
		int num = 0;
		for (T b : this) {
			a[num++] = b;
		}
		return a;
	}

	private static class Node<T> {

		T element;
		Node<T> next;
		Node<T> before;

		Node(T elem, Node<T> next, Node<T> before) {
			this.element = elem;
			this.next = next;
			this.before = before;
		}

		void setNext(Node<T> data) {
			this.next = data;
		}

		Node<T> next() {
			return this.next;
		}

		T elem() {
			return this.element;
		}

		void setBefore(Node<T> data) {
			this.before = data;
		}

		Node<T> getBefore() {
			return this.before;
		}
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <T> T[] toArray(T[] a) {
		T[] ans = (T[]) new Array[10];
		return ans;
	}
}
