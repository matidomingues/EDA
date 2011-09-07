package Ejercicio2;

public class Mirrored {
	public static <T> boolean mirror(Tree<T> tree1, Tree<T> tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		} else if (tree1 == null || tree2 == null) {
			return false;
		}

		return mirror(tree1.getLeft(), tree2.getRight())
				&& mirror(tree1.getRight(), tree2.getLeft());
	}
}
