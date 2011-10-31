package Ejercicio4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Se tiene un grafo en donde los nodos representan personas y existe un eje
 * entre dos nodos si ambas personas son amigos. Implementar un algoritmo que
 * determine si en dicho grafo se cumple la teoría de los seis grados de
 * separación, que sostiene que dos personas están conectadas a través de una
 * cadena de conocidos que no tiene más de 5 intermediarios.
 * 
 * @author matdomin
 * 
 */

public class Separation<V> {

	Node head;

	public boolean isSeparated() {
		for (Node a : head.adj) {
			if (a.isSeparated) {
				clearNodes(a);
				isSeparated(a, 0);
				visitedNodes = new HashSet<Node>();
				if (checkNodes(a)) {
					a.isSeparated = true;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private void isSeparated(Node data, int sep) {
		if (data == null || sep == 7 || data.isSeparated == true
				|| data.visited == true) {
			return;
		}

		data.visited = true;
		for (Node a : data.adj) {
			isSeparated(a, sep + 1);
		}
	}

	private boolean checkNodes(Node data) {
		if (data == null || visitedNodes.contains(data)
				|| data.isSeparated == true) {
			return true;
		}
		visitedNodes.add(data);
		if (data.visited == true) {
			for (Node a : data.adj) {
				return checkNodes(a);
			}
		}
		return false;
	}

	private void clearNodes(Node data) {
		if (data.visited == false) {
			return;
		}
		data.visited = false;
		for (Node a : data.adj) {
			clearNodes(a);
		}

	}

	Set<Node> visitedNodes;

	private class Node {
		public boolean visited;
		public List<Node> adj;
		public boolean isSeparated;
	}
}
