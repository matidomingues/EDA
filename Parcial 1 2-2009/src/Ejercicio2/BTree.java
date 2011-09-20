package Ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTree<T> {

	
	int size;
	Node<T> head;
	
	public List<T> range(int low, int upp){
		List<T> list = new LinkedList<T>();
		range(head,low,upp,list,1);
		return list;
	}
	
	private int range(Node<T> head, int low, int upp, List<T>list,int index){
		if(head == null){
			return index;
		}
			for(int i = 0; i<head.elems.size();i++){
				index = range(head.pointers.get(i),low,upp,list,index);
				if(low <= index){
					list.add(head.elems.get(i));
				}
				if(upp < index){
					return index;
				}
				index++;
				if(i == head.elems.size()-1){
					return range(head.pointers.get(i+1), low, upp, list, index);
				}
			
		}
		return index;
		
	}
	
	private static class Node<T> {
		ArrayList<T> elems;
		ArrayList<Node<T>> pointers;

		public Node(int size) {
			elems = new ArrayList<T>(size);
			pointers = new ArrayList<Node<T>>(size + 1);
		}
	}
}
