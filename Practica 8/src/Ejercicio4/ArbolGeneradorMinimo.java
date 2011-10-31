package Ejercicio4;

public class ArbolGeneradorMinimo<V, E extends ArcGraph> extends
		DiGraph<V, ArcGraph> {
	@SuppressWarnings("unchecked")
	public void getGeneratorTree() {
		Node bestNode = null;
		Arc aux = null;
		Double minlength = null;
		DiGraph<V, E> graph = new DiGraph<V, E>();
		for (Node data : nodeList) {
			for (Arc a : data.adj) {
				if (minlength == null) {
					minlength = a.info.getValue();
					aux = a;
					bestNode = data;
				} else if (minlength > a.info.getValue()) {
					minlength = a.info.getValue();
					aux = a;
					bestNode = data;
				}
			}
		}
		graph.AddVertex(bestNode.info);
		// TODO: PREGUNTAR!
		graph.addArc(bestNode.info, aux.neighbor.info, (E) aux.info);
		boolean ended = false;
		while (!ended) {
			for (Node a : nodeList) {
				if (!graph.getNodes().contains(a)) {
					ended = false;
					break;
				}
				ended = true;
			}
			searchAndAdd(graph);
		}

	}

	private void searchAndAdd(DiGraph<V, E> graph) {
		Node bestNode = null;
		Arc aux = null;
		Double minlength = null;
		for (Node data : graph.getNodes()) {
			for (Arc a : data.adj) {
				if (minlength == null) {
					minlength = a.info.getValue();
					aux = a;
					bestNode = data;
				} else if (minlength > a.info.getValue()) {
					minlength = a.info.getValue();
					aux = a;
					bestNode = data;
				}

			}
		}
		graph.AddVertex(bestNode.info);
		// TODO: PREGUNTAR!
		graph.addArc(bestNode.info, aux.neighbor.info, (E) aux.info);
	}

}
