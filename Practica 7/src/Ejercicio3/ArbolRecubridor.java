package Ejercicio3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ArbolRecubridor<T> {

	
	/**
	 * hago una copia del grafo completo y le paso esta funcion.
	 * @param head
	 */
	public void arbolRecubridor(Node head){
		if(head.visited == true){
			return;
		}
		head.visited = true;
		for(Node a: head.adj){
			if(a.visited){
				head.adj.remove(a);
			}else{
				arbolRecubridor(a);
			}
		}
	}
	
	
	public Node arbolRecubridor2(Node head){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		Node aux, actual;
		while(!queue.isEmpty()){
		}
		return null;
	}
	
	private class Node {
		public T data;
		public boolean visited;
		public List<Node> adj;
	
		public Node(T data, boolean visited){
			this.data = data;
			this.visited = visited;
			this.adj = new ArrayList<Node>(); 
		}
	}
}
