package Ejercicio2;

public class Main {
	public static void main(String[] args){
		Integer[] array = {1,2,3,4,7,6,7,8,9};
		Ordered<Integer> check = new Ordered<Integer>();
		System.out.println(check.isInAscendentOrder(array));
			
	}
}
