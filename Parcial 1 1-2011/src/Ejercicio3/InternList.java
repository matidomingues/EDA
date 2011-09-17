package Ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;

public class InternList {
	
	Integer elem;
	LinkedList<Data> data= new LinkedList<Data>();
	
	public InternList(Integer elem){
		this.elem = elem;
	}
	
	public void remove(Integer key){
		Iterator<Data> iter = data.iterator();
		while(iter.hasNext()){
			if(iter.next().key.equals(key)){
				iter.remove();
			}
		}
	}
	
	public void add(Integer key, Double elem){
		for(Data a: data){
			if(a.key.equals(key)){
				a.data = elem;
				return;
			}
		}
		data.add(new Data(key,elem));
	}
	
	public Integer getElem(){
		return this.elem;
	}
	
	public void specialAdd(Integer key, Double elems){
		for(Data a : data){
			if(a.key.equals(key)){
				a.data = a.data + elems;
				return;
			}
		}
		data.add(new Data(key,elems));
	}
	
	public Double getData(Integer key){
		for(Data a: data){
			if(a.key.equals(key)){
				return a.data;
			}
		}
		return null;
	}
	
	
	public static class Data {

		Integer key;
		Double data;
		
		public Data(Integer key, Double data){
			this.key = key;
			this.data = data;
		}
		
		public boolean equals(Data elem){
			if(this.key == elem.key){
				return true;
			}else{
				return false;
			}
		}
	}

}
