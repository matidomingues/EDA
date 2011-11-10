package Ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutomataFinito {

	private HashMap<String, Node> nodes = new HashMap<String, Node>();
	private List<Node> nodeList = new ArrayList<Node>();
	private Node head;

	public void addVertex(String vertex, boolean tag) {
		if (!nodes.containsKey(vertex)) {
			Node node = new Node(vertex, tag);
			nodes.put(vertex, node);
			nodeList.add(node);
		}
	}

	public void addArc(String v, String w, char weight) {
		Node origin = nodes.get(v);
		Node dest = nodes.get(w);
		if (origin != null && dest != null) {
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
		String info;
		boolean visited = false;
		boolean tag;
		List<Arc> adj = new ArrayList<Arc>();

		public Node(String info, boolean tag) {
			this.info = info;
			this.tag = tag;
		}

		public int hashCode() {
			return info.hashCode();
		}

		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass()) {
				return false;
			}
			return info.equals(((Node) obj).info);
		}
	}

	private class Arc {
		char letter;
		Node neighbor;

		public Arc(char letter, Node neighbor) {
			this.letter = letter;
			this.neighbor = neighbor;
		}
	}

	public AutomataFinito(String head, boolean accept) {
		addState(head, accept);
		this.head = nodes.get(head);
	}

	public void addState(String data, boolean accept) {
		this.addVertex(data, accept);
	}

	public void addTransition(String from, String to, char data) {
		this.addArc(from, to, data);
	}

	public boolean getValid(String flow) {
		return getValid(head,flow,0);
	}

	/**
	 * Si el tag esta en true es que es de aceptacion
	 */
	private boolean getValid(Node data, String flow, int loc) {
		if (loc == flow.length()) {
			if (data.tag) {
				return true;
			}else{
				return false;
			}	
		}
		for(Arc sig: data.adj){
			if(sig.letter == flow.charAt(loc)){
				System.out.println(sig.letter +" "+ flow.charAt(loc));
				return getValid(sig.neighbor,flow,loc+1);
			}
		}
		return false;
	}
	
	public static void main(String[] s) {
		AutomataFinito g = new AutomataFinito("y", false);
		g.addState("a", false);
		g.addState("n", false);
		g.addState("i", true);
		g.addTransition("y", "y", 'y');
		g.addTransition("y", "a", 'a');
		g.addTransition("a", "n", 'n');
		g.addTransition("n", "i", 'i');
		g.addTransition("i", "y", 'y');
		g.addTransition("i", "i", 'i');
		
		System.out.println(g.getValid("yyyani"));
		
	}
	

}
