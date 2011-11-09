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

	public void addArc(V v, V w) {
		Node origin = nodes.get(v);
		Node dest = nodes.get(w);
		if (origin != null && dest != null && !origin.equals(dest)) {
			for (Arc arc : origin.adj) {
				if (arc.neighbor.info.equals(w)) {
					return;
				}
			}
			origin.adj.add(new Arc(dest));
			dest.adj.add(new Arc(origin));
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

		public Arc(Node neighbor) {
			this.neighbor = neighbor;
		}
	}
	
	public int getPath(V data, int lenght){
		return getPath(nodes.get(data), lenght);
	}
	
	private int getPath(Node data, int lenght){
		if(data.visited){
			return 0;
		}else if(lenght == 0 ){
			return 1;
		}
		int sum=0;
		data.visited = true;
		for(Arc node: data.adj){
			sum += getPath(node.neighbor, lenght-1);
		}
		data.visited = false;
		return sum;
		
	}
}