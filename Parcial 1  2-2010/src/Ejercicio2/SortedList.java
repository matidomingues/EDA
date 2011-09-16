package Ejercicio2;

public interface SortedList<T> {
/**
* Agrega un elemento a la lista (en la posición correspondiente según el comparador).
* No se debe permitir almacenar valores null, si se invoca con null
* lanza IllegalArgumentException.
*/
public void add(T elem);
/**
* Elimina el elemento agregado más recientemente. Se lo puede invocar sucesivas veces,
* eliminando así los elementos en el orden inverso al que fueron agregados a la lista.
* Si la lista está vacía no hace nada.
*/
public void undo();
/**
* Imprime los elementos de la lista.
*/
public void print();
}