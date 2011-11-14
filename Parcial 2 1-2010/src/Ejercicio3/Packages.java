package Ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class Packages {

	private PackageList bestPackage = null;

	public void getBestPackage(int weight, PackageList data) {
		getBestPackage(weight, new PackageList(), data, 0);
		bestPackage.print();
	}

	private void getBestPackage(int weight, PackageList actual,
			PackageList data, int loc) {
		if (actual.totalweight > weight) {
			return;
		} else if (bestPackage == null
				|| (bestPackage.totalweight < actual.totalweight)
				|| (bestPackage.totalweight == actual.totalweight && bestPackage.totalcost > actual.totalcost)) {
			System.out.println(actual.totalcost + " " + actual.totalweight);
			bestPackage = actual.copy();
		}
		for (int i = loc; i < data.pack.size(); i++) {
			actual.addPackage(data.pack.get(i));
			getBestPackage(weight, actual, data, i + 1);
			actual.removeLast();
		}
	}

	public static class PackageList {
		private List<Node> pack = new LinkedList<Node>();
		private int totalweight = 0;
		private int totalcost = 0;

		public void addPackage(int weight, int price) {
			pack.add(new Node(weight, price));
			totalweight += weight;
			totalcost += price;
		}

		private class Node {
			private int weight;
			private int price;

			public Node(int weight, int price) {
				this.weight = weight;
				this.price = price;
			}
		}

		public void addPackage(Node data) {
			pack.add(data);
			totalweight += data.weight;
			totalcost += data.price;
		}

		public void removeLast() {
			totalweight -= pack.get(pack.size() - 1).weight;
			totalcost -= pack.get(pack.size() - 1).price;
			pack.remove(pack.size() - 1);

		}

		public PackageList copy() {
			PackageList data = new PackageList();
			for (Node a : pack) {
				data.addPackage(a);
			}
			data.totalcost = totalcost;
			data.totalweight = totalweight;
			return data;
		}

		public void print() {
			for (Node a : pack) {
				System.out.print("[" + a.weight + "," + a.price + "" + "] ");
			}
			System.out.println();
		}
	}
}
