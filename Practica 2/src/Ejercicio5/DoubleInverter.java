package Ejercicio5;

public class DoubleInverter {
	public static <T> LinearList<T> inverter(LinearList<T> list){
		LinearList<T> aux;
		if(list == null){
			return null;
		}
		inverter(list.getNext());
		aux = list;
		list.setBefore(list.getNext());
		list.setNext(aux.getBefore());
		return list;
	}
}
