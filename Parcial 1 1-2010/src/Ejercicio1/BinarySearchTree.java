package Ejercicio1;

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

}
