package Ejercicio3;

public class Test {
	public static void main(String[] args) {
		SparseMatrixDouble m1 = new SparseMatrixDoubleImpl();
		SparseMatrixDouble m2 = new SparseMatrixDoubleImpl();
		SparseMatrixDouble m3;
		m1.set(2, 3, 6.5);
		m1.set(123456789, 123456789, 13.3);
		m1.set(432, 987, -9.0);

		m2.set(2, 3, 10.0);
		m2.set(8080, 443, 74.9);
		m2.set(432, 987, 9.0);
		m2.set(5432, 1521, 7629.8);
		m2.set(8080, 443, 9.74);

		System.out.println(m1.get(554, 302)); // 0.0
		System.out.println(m1.get(123456789, 123456789)); // 13.3
		m1.remove(0, 0); // No hace nada
		m1.remove(123456789, 123456789);
		System.out.println(m1.get(123456789, 123456789)); // 0.0
		System.out.println(" ");
		System.out.println(m2.get(8080, 443)); // 9.74
		System.out.println(m2.get(432, 987)); // 9.0
		System.out.println(m2.get(5432, 1521)); // 7629.8
		System.out.println(" ");
		m3 = m1.sum(m2);
		System.out.println(m3.get(2, 3)); // 16.5
		System.out.println(m3.get(123456789, 123456789)); // 0.0
		System.out.println(m3.get(432, 987)); // 0.0
		System.out.println(m3.get(8080, 443)); // 9.74
		System.out.println(m3.get(5432, 1521)); // 7629.8
	}
}
