package Ejercicio7;

public interface BinarySearchTree<T> {
	/**
	 * Agrega una clave al árbol. Si ya existe, no hace nada y el árbol no se
	 * modifica.
	 */
	public void add(T key);

	/**
	 * Elimina una clave del árbol. Si no existe, no hace nada y el árbol no se
	 * modifica.
	 */
	public void remove(T key);

	/**
	 * Determina si el árbol contiene o no una clave.
	 */
	public boolean contains(T key);

	/**
	 * Retorna la cantidad de claves almacenadas.
	 */
	public int size();
	
	/**
	 * Retorna en que nivel se encuentra una determinada clave
	 */
	public int findKey(T key);

	/**
	 * Determina la cantidad de hojas
	 */
	public int getLeaf();
	
	/**
	 * Busca el mayor elemento
	 */
	public T getMax();
	
	/**
	 * Imprime todos los antecesores
	 */
	public void printAntescesor();
	/**
	 * Imprime todos los descendientes
	 * 
	 */
	public void printDescendants();
}
