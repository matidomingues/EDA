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
		List<Arc> adj = new ArrayList<Arc>();

		public Node(V info) {
			this.info = info;
		}

		public int hashCode() {
			return info.hashCode();
		}

		@SuppressWarnings("unchecked")
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

	Queue<Node2> arcs = new PriorityQueue<Node2>();

	private void arcs() {
		for (Node a : nodeList) {
			for (Arc b : a.adj) {
				arcs.add(new Node2(a, b.neighbor, b.value));
			}
		}
	}

	public boolean circles(Node data, Node before) {
		if (data.visited) {
			return false;
		}
		for (Arc a : data.adj) {
			if (a.neighbor != before) {
				if (!circles(a.neighbor, data)) {
					return false;
				}
			}
		}
		return true;
	}

	public void cleanMarks() {
		for (Node a : nodeList) {
			a.visited = false;
		}

	}

	public void removeArc(V v, V w) {
		Node origin = nodes.get(v);
		Node dest = nodes.get(w);
		if (origin != null && dest != null && !origin.equals(dest)) {
			for (Arc arc : origin.adj) {
				if (arc.neighbor.info.equals(w)) {
					origin.adj.remove(arc);
					break;
				}
			}
			for (Arc arc : dest.adj) {
				if (arc.neighbor.info.equals(w)) {
					dest.adj.remove(arc);
					break;
				}
			}
		}
	}

	public Graph<V> MST() {
		arcs();
		Graph<V> data = new Graph<V>();
		while (nodeList.size() != data.nodeList.size() && arcs != null) {
			Node2 aux = arcs.poll();
			if (data.nodes.get(aux.start.info) == null) {
				data.addVertex(aux.start.info);
			}
			if (data.nodes.get(aux.end.info) == null) {
				data.addVertex(aux.end.info);
			}
			data.addArc(aux.start.info, aux.end.info, aux.arc);
			cleanMarks();
			if (circles(aux.start, null)) {
				data.removeArc(aux.start.info, aux.end.info);
			}

		}
		return data;
	}

	private class Node2 implements Comparable<Node2> {
		private Double arc;
		private Node start;
		private Node end;

		public Node2(Node start, Node end, Double arc) {
			this.start = start;
			this.end = end;
			this.arc = arc;
		}

		@Override
		public int compareTo(Node2 o) {
			if (this.arc > o.arc) {
				return -1;
			} else if (this.arc == o.arc) {
				return 0;
			} else {
				return 1;
			}

		}

	}

}
