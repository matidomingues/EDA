package Ejercicio5;

public class Queue<T> {

	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();

	public void enqueue(T elem) {
		move(stack1, stack2);
		stack1.push(elem);
		move(stack2,stack1);
	}
	
	public T dequeue(){
		if(stack1.isEmpty()){
			return null;
		}
		return stack1.pop();
	}

	private void move(Stack<T> elem1, Stack<T> elem2) {
		while (!elem1.isEmpty()) {
			elem2.push(elem1.pop());
		}

	}
	
	public boolean isEmpty(){
		return stack1.isEmpty();
	}

}
