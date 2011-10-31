package Ejercicio1;

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

	public boolean hasCircles(){
		
		for(Node data: nodeList){
			clearMarks();
			if(!hasCircles(data)){
				return false;
			}
		}
		return true;
		
	}
	private boolean hasCircles(Node data){
		if(data.visited){
			return true;
		}else if(data.adj.size() == 0){
			return false;
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

}
