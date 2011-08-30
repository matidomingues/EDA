package Ejercicio5;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> test = new Queue<Integer>();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		test.dequeue();
		test.enqueue(4);
		test.enqueue(5);
		while(!test.isEmpty()){
			System.out.println(test.dequeue());
		}

	}

}
