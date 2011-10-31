package Ejercicio5;

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

	public boolean hasCircles(V node){
		Node data = nodes.get(node);
		return hasCircles(data);
		
		
	}
	private boolean hasCircles(Node data){
		if(data.visited){
			return false;
		}else if(data.adj.size() == 0){
			return true;
		}
		boolean tru;
		for(Arc a: data.adj){
			a.neighbor.visited = true;
			tru = hasCircles(a.neighbor);
			if(!tru){
				return false;
			}
		}
		return true;
	}

	public int getCareerTime(Node head){
		return getCareerTime(head, 0);
	}
	
	private int getCareerTime(Node head, int depth){
		if(head.adj == null){
			return depth;
		}
		Integer prof = null;
		for(Arc a: head.adj){
			int aux = getCareerTime(a.neighbor, depth +1);
			if(prof == null){
				prof = aux;
			}else if(prof < aux){
				prof = aux;
			}
		}
		return prof;
	}
	
}
