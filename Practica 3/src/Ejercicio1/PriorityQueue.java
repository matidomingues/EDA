package Ejercicio1;

public interface PriorityQueue<T> {
	/**
	* Encola un elemento.
	* @param priority Un número mayor a cero que especifica la prioridad. Cuanto
	* menor es este número mayor es la prioridad.
	*/
	public void enqueue(T elem, int priority);
	/**
	* Desencola un elemento.
	* @throws NoSuchElementException Si la cola está vacía.
	*/
	public T dequeue();
	/**
	* Evalúa si la cola está vacía o no.
	*/
	public boolean isEmpty();
	}