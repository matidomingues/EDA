package Ejercicio4;

public class isBST{

	public boolean isSearchTree(Tree<Integer> tree, Integer min, Integer max){
		if(tree == null){
			return true;
		}
		if(tree.getData() < max && tree.getData() > min){
			return isSearchTree(tree.getLeft(),min,tree.getData()) && 
			isSearchTree(tree.getRight(),tree.getData(), max);
		}else{
			return false;
		}
	}
}
