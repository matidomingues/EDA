package Ejercicio4;

public class LinearList<T> {
	private T data;
	private LinearList<T> next;
	
	public LinearList(T data, LinearList<T> next){
		this.data = data;
		this.next = next;
	}
	public T getData(){
		return data;
	}
	
	public LinearList<T> getNext(){
		return next;
	}
	public LinearList<T> addR(T data){
		return new LinearList<T>(data,this);
		
	}
	public LinearList<T> add(T data){
		this.next = new LinearList<T>(data,null);
		return next.next;
	}
}
