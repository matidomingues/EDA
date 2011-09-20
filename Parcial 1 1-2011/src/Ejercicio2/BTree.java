package Ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BTree<T extends Comparable<? super T>> {
	
	int size;
	Node<T> head;
	
	public List<T> lessThan(T elem){
		List<T> list = new LinkedList<T>();
		lessThan(head, elem,list);
		return list;
	}
	
	private void lessThan(Node<T> tree, T elem, List<T> list){
		if(tree == null){
			return;
		}
		for(int i = 0; i<tree.elems.size(); i++){
			if(tree.elems.get(i).compareTo(elem)<0){
				lessThan(tree.pointers.get(i),elem, list);
				if(i == size){
					lessThan(tree.pointers.get(i+1), elem, list);
				}
			}else if(tree.elems.get(i).compareTo(elem) == 0){
				lessThan(tree.pointers.get(i), elem,list);
			}else{
				lessThan(tree.pointers.get(i), elem, list);
				return;
			}
			list.add(tree.elems.get(i));
		}
		
	}
	
	private static class Node<T>{
		ArrayList<T> elems;
		ArrayList<Node<T>> pointers;
		
		public Node(int size){
			elems = new ArrayList<T>(size);
			pointers = new ArrayList<Node<T>>(size+1);
		}
	}
	
	
	
}
