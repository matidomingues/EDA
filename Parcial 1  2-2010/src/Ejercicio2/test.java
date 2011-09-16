package Ejercicio2;

public class test {
	public static void main(String[] args) {
		SortedList<String> list = new SortedListImp<String>();
		list.add("C");
		list.add("A");
		list.add("D");
		list.add("B");
		list.print(); // imprime "A B C D"
		list.undo();
		list.print(); // imprime "A C D"
		list.undo();
		list.undo();
		list.print(); // imprime "C"
	}
}
