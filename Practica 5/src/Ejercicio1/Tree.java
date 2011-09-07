package Ejercicio1;

public class Tree<T> {

	
	
	private static class Node<T> {
		Node<T> right;
		Node<T> left;
		T data;
		
		public Node(T data, Node<T> right, Node<T> left){
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

		public Node<T> getRight() {
			return right;
		}

		public Node<T> getLeft() {
			return left;
		}
	}
}
