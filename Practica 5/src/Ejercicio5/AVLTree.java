package Ejercicio5;

public class AVLTree<T> {
	public boolean isAVL(Tree<T> tree){
		int a = isAVLWrapper(tree);
		if(a >= -1 && a <= 1){
			return true;
		}
		return false;
	}
	
	private int isAVLWrapper(Tree<T> tree){
		if(tree == null){
			return 1;
		}
		return (isAVLWrapper(tree.getLeft())- isAVLWrapper(tree.getRight()));
	}
}
