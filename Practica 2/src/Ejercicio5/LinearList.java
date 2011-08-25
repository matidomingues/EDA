package Ejercicio5;

public class LinearList<T> {
	private T data;
	private LinearList<T> next;
	private LinearList<T> before;
	
	public LinearList(T data, LinearList<T> next, LinearList<T> before){
		this.data = data;
		this.next = next;
		this.before = before;
	}
	public T getData(){
		return data;
	}
	
	public LinearList<T> getNext(){
		return next;
	}
	
	public LinearList<T> getBefore(){
		return before;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public void setNext(LinearList<T> data){
		this.next = data;
	}
	
	public void setBefore(LinearList<T> data){
		this.before = data;
	}
	
	public LinearList<T> addR(T data){
		return new LinearList<T>(data,this,null);
		
	}
	public LinearList<T> add(T data){
		this.next = new LinearList<T>(data,null,null);
		return next.next;
	}
}
