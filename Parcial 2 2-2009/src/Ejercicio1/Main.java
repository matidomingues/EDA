package Ejercicio1;

public class Main {

	public static void main(String[] args) {
		Graph<String> test = new Graph<String>();
		test.addVertex("A", 2);
		test.addVertex("B", 9);
		test.addVertex("D", 2);
		test.addVertex("C", 1);
		test.addArc("A", "B", 1);
		test.addArc("B", "A", 1);
		test.addArc("B", "D", 8);
		test.addArc("D", "B", 8);
		test.addArc("D", "C", 1);
		test.addArc("C", "D", 1);
		test.addArc("B", "C", 1);
		test.addArc("C", "B", 1);
		test.addArc("A", "C", 3);
		test.addArc("C", "A", 3);
		System.out.println(test.getMinPath("A", "D"));
	}


}
