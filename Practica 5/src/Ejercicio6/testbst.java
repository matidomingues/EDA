package Ejercicio6;

public class testbst {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinaryTree<Integer>();
		bst.add(100);
		bst.add(50);
		bst.add(250);
		bst.add(30);
		bst.add(70);
		bst.add(270);
		bst.add(10);
		bst.add(40);
		bst.add(260);
		System.out.println(bst.getInOrder(1, 2));
	}
}
