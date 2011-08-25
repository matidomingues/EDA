package Ejercicio6;

import java.util.Iterator;

public interface Iterate<T> extends Iterator<T> {
	public void add(T elem);
}
