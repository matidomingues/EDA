package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		SetImp<Integer> test = new SetImp<Integer>();
		test.add(1);
		test.add(2);
		//test.remove(2);
		System.out.println(test.size());
		System.out.println(test.toArray());
		for (Integer a : test) {
			System.out.print(a + " ");
		}
		
	}
}
