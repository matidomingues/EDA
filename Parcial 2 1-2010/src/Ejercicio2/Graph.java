package Ejercicio2;

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

	private void clearMarks() {
		for (Node a : nodeList) {
			a.visited = false;
		}
	}

	private Node getHead() {
		Node aux = null;
		for (Node a : nodeList) {
			for (Arc arc : a.adj) {
				arc.neighbor.visited = true;
			}
		}
		for (Node a : nodeList) {
			if (!a.visited) {
				if (aux != null) {
					return null;
				}
				aux = a;
			}
		}
		return aux;
	}

	private boolean getCircles(Node a) {
		if (a.visited) {
			return false;
		}
		a.visited = true;
		for (Arc node : a.adj) {
			if (!getCircles(node.neighbor)) {
				return false;
			}
		}
		return true;
	}

	public Node getTree() {
		Node aux;
		if ((aux = getHead()) != null && !getCircles(aux)) {
			return aux;
		}
		return null;

	}
}