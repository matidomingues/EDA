package Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

	public int getMinPath(V startNode, V endNode) {
		return getMinPath2(nodes.get(startNode), nodes.get(endNode));
	//	return getMinPath(nodes.get(startNode), nodes.get(endNode), 0, null);
	}

	/**
	 *	HOLA VICKY, ESTE ESTA MAL, VA EL getMinPath2
	 */
	private Integer getMinPath(Node start, Node end, int sum, Integer data) {
		if (start.visited) {
			return null;
		} else if (start == end) {
			return sum + end.weight;
		}
		Integer local;
		start.visited = true;
		for (Arc sig : start.adj) {
			local = getMinPath(sig.neighbor, end, sum + start.weight
					+ sig.weight, data);
			if (local != null && (data == null || data > local)) {
				data = local;
			}
		}
		start.visited = false;
		return data;
	}

	private Integer getMinPath2(Node start, Node end) {
		Queue<Node2> data = new PriorityQueue<Node2>();
		data.add(new Node2(start, start.weight));
		Node2 aux;
		while (!data.isEmpty()) {
			aux = data.poll();
			aux.data.visited = true;
			if (aux.data == end) {
				return aux.value;
			}
			for (Arc a : aux.data.adj) {
				if (!a.neighbor.visited) {
					data.add(new Node2(a.neighbor, aux.value + a.weight
							+ a.neighbor.weight));
				}
			}
			aux.data.visited = false;
		}
		return null;

	}

	private class Node2 implements Comparable {
		Node data;
		int value;

		public Node2(Node data, int value) {
			this.data = data;
			this.value = value;
		}

		@Override
		public int compareTo(Object o) {
			if (this.value < ((Node2) o).value) {
				return -1;
			} else if (this.value == ((Node2) o).value) {
				return 0;
			} else {
				return 1;
			}
		}

	}
}
