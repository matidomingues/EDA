package Ejercicio3;

public class Array {
	public static void main(String[] args){
		Integer[] array = {1,2,3,4,5,6,7,8};
		Duplicated<Integer> test = new Duplicated<Integer>();
		System.out.println(test.method1(array));
		System.out.println(test.method2(array));
		System.out.println(test.method3(array));
		
	}
}
