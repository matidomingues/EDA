package Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph<V> {
	private HashMap<V, Node> nodes = new HashMap<V, Node>();
	private List<Node> nodeList = new ArrayList<Node>();

	public void addVertex(V vertex) {
		if (!nodes.containsKey(vertex)) {
			Node node = new Node(vertex);
			nodes.put(vertex, node);
			nodeList.add(node);
		}
	}

	public void addArc(V v, V w, Double value) {
		Node origin = nodes.get(v);
		Node dest = nodes.get(w);
		if (origin != null && dest != null && !origin.equals(dest)) {
			for (Arc arc : origin.adj) {
				if (arc.neighbor.info.equals(w)) {
					return;
				}
			}
			origin.adj.add(new Arc(dest, value));
			dest.adj.add(new Arc(origin, value));
		}
	}

	private class Node {
		V info;
		boolean visited = false;
		int tag = 0;
		List<Arc> adj = new ArrayList<Arc>();

		public Node(V info) {
			this.info = info;
		}

		public int hashCode() {
			return info.hashCode();
		}

		public boolean equals(Object obj) {
			if (obj == null || !(obj.getClass() != getClass())) {
				return false;
			}
			return info.equals(((Node) obj).info);
		}
	}

	private class Arc {
		Node neighbor;
		Double value;

		public Arc(Node neighbor, Double value) {
			this.neighbor = neighbor;
			this.value = value;
		}
	}
	
	Queue<Node> arcs = new PriorityQueue<Node>();
	
	public Graph MST(){
		
	}
	
}



