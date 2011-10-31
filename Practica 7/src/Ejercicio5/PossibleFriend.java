package Ejercicio5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleFriend {

	public List<Node> getFriends(Node head, int n) {
		Set<Node> dFriends = new HashSet<Node>();
		List<Node> friends = new ArrayList<Node>();
		for (Node a : head.adj) {
			dFriends.add(a);
		}
		for (Node a : head.adj) {
			for (Node b : a.adj) {
				if (!b.visited) {
					if (checkFriends(head, b, n, dFriends)) {
						friends.add(b);
					}
				}
			}
		}
		return friends;
	}

	private boolean checkFriends(Node head, Node data, int n, Set<Node> adj) {
		int sum = 0;
		data.visited = true;
		for (Node a : data.adj) {
			if (a == head) {
				return false;
			}
			if (adj.contains(a)) {
				sum++;
			}
		}
		if (sum >= n) {
			return true;
		}
		return false;
	}

	private class Node {
		public boolean visited;
		public List<Node> adj;
	}
}
