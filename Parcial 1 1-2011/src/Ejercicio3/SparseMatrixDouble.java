package Ejercicio3;

/**
* Matriz bidimensional infinita de valores Double.
* La matriz se crea inicialmente con valores nulos.
*/
public interface SparseMatrixDouble {
/**
* Agrega un valor en la posición determinada por los parámetros de entrada.
* Si ya existe un valor en esa posición, actualiza el mismo con el nuevo parámetro.
*/
public void set(int row, int col, Double value);
/**
* Elimina el valor ubicado en la fila y columna de la matriz, según los parámetros de
* entrada.
* Si valor en esa posición fuera nulo, no hace nada.
*/
public void remove(int row, int col);
/**
* Obtiene el valor asociado a una posición de la matriz determinada por los parámetros
* de entrada.
*/
public Double get(int row, int col);
/**
* Retorna la suma de dos matrices.
* En caso de que exista algún error, retorna null.
*/
public SparseMatrixDouble sum(SparseMatrixDouble otherSparseMatrix);
}
