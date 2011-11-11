package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph<V> {
	private HashMap<V, Node> nodes = new HashMap<V, Node>();
	private List<Node> nodeList = new ArrayList<Node>();

	public void addVertex(V vertex, int weight) {
		if (!nodes.containsKey(vertex)) {
			Node node = new Node(vertex, weight);
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
		int weight;
		boolean visited = false;
		int tag = 0;
		List<Arc> adj = new ArrayList<Arc>();

		public Node(V info, int weight) {
			this.info = info;
			this.weight = weight;
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
		int weight;
		Node neighbor;

		public Arc(int weight, Node neighbor) {
			this.weight = weight;
			this.neighbor = neighbor;
		}
	}

	/**
	 * ESTA MAL, CALCULA LOS CICLOS TOTALES Y NO LOS DE A.
	 * EL countCycles2 ANDA BIEN
	 */
	public int countCycles(V a) {
		List<Node2> data = new LinkedList<Node2>();
		data.add(new Node2(nodes.get(a), null));
		Node2 aux;
		int count = 0;
		nodes.get(a).visited = true;
		while (!data.isEmpty()) {
			aux = data.get(0);
			data.remove(0);
			for (Arc node : aux.node.adj) {
				if (node.neighbor != aux.called) {
					if (node.neighbor.visited) {
						count++;
					} else {
						node.neighbor.visited = true;
						data.add(new Node2(node.neighbor, aux.node));
					}
				}
			}

		}
		return (int) (count / 2);

	}

	private class Node2 {
		Node node;
		Node called;

		public Node2(Node node, Node called) {
			this.node = node;
			this.called = called;
		}

	}

	public int countCycles2(V a) {
		return countCycles(nodes.get(a), null, nodes.get(a)) / 2;
	}

	private Integer countCycles(Node data, Node before, Node end) {
		if (data.visited && data == end) {
			return 1;
		} else if (data.visited) {
			return 0;
		}
		data.visited = true;
		int sum = 0;
		for (Arc a : data.adj) {
			if (a.neighbor != before) {
				sum += countCycles(a.neighbor, data, end);
			}
		}
		data.visited = false;
		return sum;

	}

}