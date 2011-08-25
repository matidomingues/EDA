package Ejercicio3;


public class Union {
	public static <T extends Comparable<T>> LinearList<T> union(LinearList<T>...baseLists){
		T data = null;
		LinearList<T> aux;
		for(LinearList<T> list: baseLists){
			if(data == null){
				data = list.getData();
			}else{
				if(data.compareTo(list.getData())== -1){
					data = list.getData();
				}
			}
		}
		for(LinearList<T> list: baseLists){
			if(list.getData().compareTo(data) == 0){
				list = list.getNext();
			}
		}
		aux = union(baseLists);
		return aux.addR(data);
	}
}
