package Ejercicio1;

/**
 * Mapa que mantiene información histórica de su estado a través de versiones.
 * El mapa se crea inicialmente vacío, con número de versión 0. Luego cada vez
 * que se lo modifica, se incrementa la versión.
 */
public interface VersionableMap<K, V> {
	/**
	 * Agrega un par clave-valor al mapa. Cada vez que se invoca a este método
	 * se incrementa en uno la versión. No se deben admitir claves ni valores
	 * nulos. Si la clave ya existe, actualiza su valor asociado.
	 */
	public void put(K key, V value);

	/**
	 * Elimina un par clave-valor del mapa, según la clave especificada. Si la
	 * clave no existe no hace nada. Cada vez que se invoca a este método se
	 * incrementa en uno la versión.
	 */
	public void remove(K key);

	/**
	 * Obtiene el valor asociado a una clave dada una versión específica del
	 * mapa. Si la clave no existe, retorna null.
	 */
	public V get(K key, int version);
}
