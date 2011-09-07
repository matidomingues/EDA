package Ejercicio4;

public class Tree<T> {

	Tree<T> right;
	Tree<T> left;
	T data;

	public Tree(T data, Tree<T> right, Tree<T> left) {
		this.data = data;
		this.right = right;
		this.left = left;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Tree<T> getRight() {
		return right;
	}

	public Tree<T> getLeft() {
		return left;
	}
}
