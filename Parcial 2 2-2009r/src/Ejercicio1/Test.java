package Ejercicio1;

public class Test {

	public static void main(String[] args) {
		Graph<String> test = new Graph<String>();
		test.addVertex("A");
		test.addVertex("B");
		test.addVertex("C");
		test.addVertex("D");
		test.addArc("A","B");
		test.addArc("B","A");
		test.addArc("A","C");
		test.addArc("C","A");
		test.addArc("B","C");
		test.addArc("C","B");
		test.addArc("C","D");
		test.addArc("D","C");
		test.addArc("B","D");
		test.addArc("D","B");
		System.out.println(test.getPath("B", 1));
		
	}

}
