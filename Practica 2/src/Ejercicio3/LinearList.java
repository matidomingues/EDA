package Ejercicio3;

public class LinearList<T> {
	private T data;
	private LinearList<T> next;
	
	public T getData(){
		return data;
	}
	
	public LinearList<T> getNext(){
		return next;
	}
	public LinearList<T> addR(T data){
		LinearList<T> a = new LinearList<T>();
		a.data = data;
		a.next = this;
		return a;
	}

}
