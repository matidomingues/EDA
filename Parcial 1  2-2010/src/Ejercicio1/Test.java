package Ejercicio1;

import java.util.Comparator;

public class Test {	
	public static void main(String[] args) {
		BST<Integer> test = new BST<Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0.compareTo(arg1);
			}
			
		});
		
		test.add(100);
		test.add(60);
		test.add(120);
		test.add(30);
		test.add(7);
		test.add(110);
		test.add(150);
		test.add(12);
		test.add(1);
		test.add(523);
		System.out.println(test.getInOrder());
	}
}
