package Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	public void addArc(V v, V w, int weight) {
		Node origin = nodes.get(v);
		Node dest = nodes.get(w);
		if (origin != null && dest != null && !origin.equals(dest)) {
			for (Arc arc : origin.adj) {
				if (arc.neighbor.info.equals(w)) {
					return;
				}
			}
			origin.adj.add(new Arc(weight, dest));
			dest.adj.add(new Arc(weight, origin));
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
			if (obj == null || obj.getClass() != getClass()) {
				return false;
			}
			return info.equals(((Node) obj).info);
		}
	}

	private class Arc {
		int weight;
		Node neighbor;

		public Arc(int weight, Node neighbor) {
			this.weight = weight;
			this.neighbor = neighbor;
		}
	}
	
	public int getMax(V start, V end){
		return getMax(nodes.get(start), nodes.get(end),0,0,0);
	}
	
	private int getMax(Node start, Node end, int sum, int maxlen, int localen){
		if(start.visited){
			return 0;
		}else if(start == end){
			if(localen > maxlen){
				return sum;
			}else{
				return 0;
			}
		}
		start.visited = true;
		for(Arc a: start.adj){
			getMax(a.neighbor, end, sum, maxlen, localen);
		}
		return 0;
		
	}
	
}
