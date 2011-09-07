package Ejercicio1;

public class NewTree<T, S> {
	public Tree<S> createTree(Tree<T> tree1, Function<T, S> eval) {
		if (tree1 == null) {
			return null;
		}
		return new Tree<S>(eval.evaluate(tree1.getData()), createTree(tree1
				.getLeft(), eval), createTree(tree1.getRight(), eval));
	}
}
