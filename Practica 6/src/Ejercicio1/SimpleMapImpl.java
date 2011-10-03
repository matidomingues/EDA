package Ejercicio1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public class SimpleMapImpl<K,V> implements SimpleMap<K,V> {

	ArrayList<LinkedList<Node>> elem = new ArrayList<LinkedList<Node>>();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Object get(Object key) {
		for(Node a: elem.get(key.hashCode())){
			if(a.key.equals(key)){
				return a.data;
			}
		}
		return null;
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		LinkedList<Node> aux = elem.get(key.hashCode());
		if(aux == null){
			elem.add(key.hashCode(), new LinkedList<Node>());
			elem.get(key.hashCode()).add(new Node((K)key, (V)value));
		}else{
			elem.get(key.hashCode()).add(new Node((K)key, (V)value));
		}
	}

	@Override
	public void remove(Object key) {
		LinkedList<Node> aux = elem.get(key.hashCode());
		if(aux != null){
			for(int i = 0; i<aux.size(); i++){
				if(aux.get(i).key.equals(key)){
					aux.remove(i);
					return;
				}
			}
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	private class Node{
		K key;
		V data;
		
		public Node(K key, V data){
			this.key = key;
			this.data = data;
		}
	}
}
