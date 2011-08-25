package Ejercicio1;

public class TestQueue {
	public static void main(String[] args){
		PriorityQueueImp<Integer> cola = new PriorityQueueImp<Integer>();
		cola.enqueue(1, 1);
		cola.enqueue(2, 2);
		cola.enqueue(3, 3);
		cola.dequeue();
		//System.out.println(cola.dequeue());
		cola.enqueue(4, 4);
		cola.enqueue(5, 5);
		cola.enqueue(6, 2);
		cola.enqueue(9, 1);
		while(!cola.isEmpty()){
			System.out.println(cola.dequeue());
		}
		
	}
}
