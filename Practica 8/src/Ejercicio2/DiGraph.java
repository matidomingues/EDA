package Ejercicio2;

public class DiGraph<V, E extends ArcGraph> extends GraphAdjList<V, E> {

	public int inDegree(V v) {
		int count = 0;
		Node node = nodes.get(v);
		for (Node n : getNodes()) { // Recorremos lista de nodos
			if (!n.equals(node)) {
				for (Arc adj : n.adj)
					// Recorremos lista de adyacencia
					if (adj.neighbor.equals(node))
						count++;
			}
		}
		return count;
	}

	public int outDegree(V v) {
		Node node = nodes.get(v);
		if (node != null) {
			return node.adj.size();
		}
		return 0;
	}

	public boolean hasCircles(V node) {
		Node data = nodes.get(node);
		return hasCircles(data);

	}

	private boolean hasCircles(Node data) {
		if (data.visited) {
			return false;
		} else if (data.adj.size() == 0) {
			return true;
		}
		boolean tru;
		for (Arc a : data.adj) {
			a.neighbor.visited = true;
			tru = hasCircles(a.neighbor);
			if (!tru) {
				return false;
			}
		}
		return true;
	}

	public boolean strongConnected() {
		for (Node a : nodeList) {
			clearMarks();
			if (!searchNode(a, a)) {
				return false;
			}
		}
		return true;

	}

	private boolean searchNode(Node data, Node search) {
		if (data.visited && data == search) {
			return true;
		} else if (data.visited) {
			return false;
		}
		data.visited = true;
		boolean tru;
		for (Arc a : data.adj) {
			tru = searchNode(a.neighbor, search);
			if (tru == true) {
				return true;
			}
		}
		return false;
	}
}
