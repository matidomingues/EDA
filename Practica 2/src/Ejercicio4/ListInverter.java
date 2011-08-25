package Ejercicio4;

public class ListInverter {
	public static <T> LinearList<T> inverter(LinearList<T> list){
		LinearList<T> node = null;
		while(list != null){
			node = new LinearList<T>(list.getData(),node);
		}
		return node;
	}
}