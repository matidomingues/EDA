package Ejercicio4;

public class Fibonacci {

	public static void main(String args[]){
		System.out.println(fibo2(30));
		System.out.println(fibo(30));
	}
	
	public static int fibo(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}

	public static int fibo2(int n){
		return fibo2(n-1,new Node(0,1));
	}
	
	private static int fibo2(int n, Node actual) {
		if(n == 0){
			return actual.data;
		}
		return fibo2(n-1, new Node(actual.data,actual.data + actual.prev));
	}

	public static class Node {
		int prev;
		int data;

		public Node(int prev, int data) {
			this.prev = prev;
			this.data = data;
		}
	}
}
