package Ejercicio9;

import java.util.Iterator;

public class TestTree {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinaryTree<Integer>();
		tree.add(5);
		tree.add(2);
		tree.add(7);
		tree.add(3);
		tree.add(4);
		tree.add(1);
		tree.add(0);
		tree.add(9);
		tree.add(8);
		tree.add(24);
		tree.add(-4);
		Iterator<Integer> iter = tree.postOrderIterator();
		while(!iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		
		
	
	}
}
