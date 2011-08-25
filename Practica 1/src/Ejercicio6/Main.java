package Ejercicio6;

public class Main {
	public static void main(String[] args){
		Integer[] a = {4,2,6,8,3,10};
		Integer[] b = {2,7,6,4,11};
		Union<Integer> data = new Union<Integer>();
		System.out.println(data.getUnion1(a, b));
//		System.out.println(data.getUnion2(a, b));
	}
}
