package Ejercicio1;

public class VersionableMapImpl<K, V> implements VersionableMap<K, V> {
	/**
	 * 10:43 - 11: 34
	 */
	Node<K, V> head = null;
	Node<K, V> tail = null;
	int version = 0;

	@Override
	public void put(K key, V value) {
		version++;
		if (head == null) {
			tail = head = new Node<K, V>(key, value, null, version);
		} else {
			Node<K,V> aux = head;
			while(aux != null){
				if(aux.key.equals(key)){
					aux.list.add(value, version);
					return;
				}
				aux = aux.sig;
			}
			tail.sig = new Node<K, V>(key, value, null, version);
			tail = tail.sig;
		}
	}

	@Override
	public void remove(K key) {
		version++;
		Node<K, V> aux = head;
		while (aux != null) {
			if (aux.key.equals(key)) {
				aux.list.add(null, version);
			}
			aux = aux.sig;
		}
	}

	@Override
	public V get(K key, int version) {
		Node<K, V> aux = head;
		while (aux != null) {
			if (aux.key.equals(key)) {
				return aux.list.getData(version);
			}
			aux = aux.sig;
		}
		return null;
	}

	private static class Node<K, V> {
		K key;
		Stack<V> list = new Stack<V>();
		Node<K, V> sig;

		public Node(K key, V elem, Node<K, V> sig, int version) {
			this.key = key;
			list.add(elem, version);
			this.sig = sig;
		}
	}

}
